package baseball2.controller;

import baseball2.domain.AnswerGenerator;
import baseball2.domain.AnswerKind;
import baseball2.domain.BaseBallRecord;
import baseball2.domain.BaseBallResult;
import baseball2.service.GameService;
import baseball2.view.GameView;

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

      if (answerKind == AnswerKind.CORRECT) {
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
