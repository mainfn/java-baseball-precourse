package baseball;

import baseball.controller.GameController;
import baseball.service.GameService;
import baseball.util.RandomNumbersGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

public final class Application {

  public static void main(final String[] args) {
    final OutputView outputView = new OutputView();
    final InputView inputView = new InputView(outputView);
    final RandomNumbersGenerator randomNumbersGenerator = new RandomNumbersGenerator(1, 9);
    final GameService gameService = new GameService();
    final GameController gameController = new GameController(inputView, outputView,
        randomNumbersGenerator, gameService);

    gameController.start();
  }
}
