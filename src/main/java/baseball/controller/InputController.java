package baseball.controller;

import baseball.domain.GameCommand;
import baseball.view.InputView;

public final class InputController {

  public static int inputBallNumber() {
    final String ballNumberString = InputView.inputBallNumber();
    InputValidator.validateBallNumber(ballNumberString);

    return Integer.parseInt(ballNumberString);
  }

  public static GameCommand inputGameCommand() {
    final String gameCommandString = InputView.inputGameCommand();
    InputValidator.validateGameCommand(gameCommandString);

    return GameCommand.of(gameCommandString);
  }
}
