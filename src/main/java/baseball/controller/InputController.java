package baseball.controller;

import baseball.domain.BallNumber;
import baseball.domain.GameCommand;
import baseball.view.InputView;

public final class InputController {

  public static BallNumber inputBallNumber() {
    final String ballNumberString = InputView.inputBallNumber();
    InputValidator.validateBallNumberFormat(ballNumberString);

    return BallNumber.from(ballNumberString);
  }

  public static GameCommand inputGameCommand() {
    final String gameCommandString = InputView.inputGameCommand();

    return GameCommand.of(gameCommandString);
  }
}
