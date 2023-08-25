package baseball;

import baseball.controller.GameController;
import baseball.controller.InputManager;
import baseball.domain.AnswerGenerator;
import baseball.domain.RandomNumberGenerator;
import baseball.service.GameService;
import baseball.view.GameView;

public final class Application {

  public static void main(final String[] args) {
    final InputManager inputManager = new InputManager();
    final GameView gameView = new GameView();
    final AnswerGenerator answerGenerator = new AnswerGenerator(new RandomNumberGenerator(1, 9));
    final GameService gameService = new GameService();
    final GameController gameController = new GameController(gameService, inputManager,
        answerGenerator, gameView);

    gameController.start();
  }
}
