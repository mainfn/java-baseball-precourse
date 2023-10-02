package baseball;

import baseball.controller.GameController;
import baseball.domain.RandomBallNumberGenerator;
import baseball.domain.RandomNumberGenerator;

public final class Application {

  public static void main(final String[] args) {
    final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator(1, 9);
    final RandomBallNumberGenerator randomBallNumberGenerator = new RandomBallNumberGenerator(
        randomNumberGenerator);
    final GameController gameController = new GameController(randomBallNumberGenerator);

    gameController.run();
  }
}
