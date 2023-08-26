package baseball.controller;

import baseball.domain.AnswerGenerator;
import baseball.domain.AnswerKind;
import baseball.domain.BaseBallRecord;
import baseball.domain.BaseBallResult;
import baseball.service.GameService;
import baseball.view.GameView;

public final class GameController {

  private final GameService gameService;
  private final InputManager inputManager;

  private final AnswerGenerator answerGenerator;

  private final GameView gameView;

  public GameController(
      final GameService gameService,
      final InputManager inputManager,
      final AnswerGenerator answerGenerator,
      final GameView gameView
  ) {
    this.gameService = gameService;
    this.inputManager = inputManager;
    this.answerGenerator = answerGenerator;
    this.gameView = gameView;
  }

  public void start() {
    final BaseBallRecord answer = answerGenerator.generate();

    while (true) {
      final AnswerKind answerKind = guess(answer);
      final boolean isCorrect = answerKind == AnswerKind.CORRECT;

      if (isCorrect) {
        break;
      }
    }

    if (inputManager.askQuit()) {
      return;
    }
    start();
  }

  private AnswerKind guess(final BaseBallRecord answer) {

    final BaseBallRecord guess = inputManager.inputBaseBallRecord();
    final BaseBallResult result = gameService.getResult(guess, answer);

    return gameView.render(result);
  }


}
