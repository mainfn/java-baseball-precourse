package baseball.controller;

import baseball.domain.BallNumber;
import baseball.domain.GameCommand;
import baseball.domain.GameManager;
import baseball.domain.GuessResult;
import baseball.domain.RandomBallNumberGenerator;
import baseball.view.OutputView;

public final class GameController {

  private final RandomBallNumberGenerator randomBallNumberGenerator;

  public GameController(final RandomBallNumberGenerator randomBallNumberGenerator) {
    this.randomBallNumberGenerator = randomBallNumberGenerator;
  }

  public void run() {
    final GameManager gameManager = createGameManager();
    play(gameManager);
    restartOrQuit();
  }

  private GameManager createGameManager() {

    final BallNumber answer = randomBallNumberGenerator.generate();
    return new GameManager(answer);
  }

  private void play(final GameManager gameManager) {
    while (true) {
      final BallNumber ballNumber = InputController.inputBallNumber();
      final GuessResult result = gameManager.guess(ballNumber);
      OutputView.printGuessResult(result);

      if (result.isThreeStrikes()) {
        break;
      }
    }

  }

  private void restartOrQuit() {
    final GameCommand gameCommand = InputController.inputGameCommand();
    if (GameCommand.RESTART == gameCommand) {
      run();
    }
  }

}
