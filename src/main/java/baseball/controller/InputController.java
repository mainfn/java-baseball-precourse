package baseball.controller;

import baseball.domain.GameCommand;
import baseball.view.InputView;

public final class InputController {

  public static int inputBallNumber() {
    final String ballNumberString = InputView.inputBallNumber();
    InputValidator.validateBallNumberFormat(ballNumberString);

    return Integer.parseInt(ballNumberString);
  }

  public static GameCommand inputGameCommand() {
    final String gameCommandString = InputView.inputGameCommand();

    return GameCommand.of(gameCommandString);
  }
}
