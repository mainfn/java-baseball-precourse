package baseball.controller;

import baseball.view.InputView;

public final class InputController {

  public static int inputBallNumber() {
    final String ballNumberString = InputView.inputBallNumber();
    InputValidator.validateBallNumber(ballNumberString);

    return Integer.parseInt(ballNumberString);
  }
}
