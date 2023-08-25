package baseball2;

import baseball2.controller.GameController;
import baseball2.controller.InputManager;
import baseball2.domain.AnswerGenerator;
import baseball2.domain.RandomNumberGenerator;
import baseball2.service.GameService;
import baseball2.view.GameView;

public final class Application {

  public static void main(final String[] args) {
    final InputManager inputManager = new InputManager();
    final GameView gameView = new GameView();
    final AnswerGenerator answerGenerator = new AnswerGenerator(new RandomNumberGenerator(1, 9));
    final GameService gameService = new GameService(answerGenerator);
    final GameController gameController = new GameController(gameService, inputManager,
        answerGenerator, gameView);

    gameController.start();
  }
}
