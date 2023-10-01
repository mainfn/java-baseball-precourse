package baseball.controller;

public final class InputValidator {

  public static void validateBallNumber(final String ballNumber) {
    validateBallNumberLength(ballNumber);
    validateBallNumberFormat(ballNumber);
  }

  private static void validateBallNumberLength(final String ballNumber) {
    if (ballNumber.length() != 3) {
      throw new IllegalArgumentException("BallNumber는 3자리 수여야 합니다.");
    }
  }

  private static void validateBallNumberFormat(final String ballNumber) {
    try {
      Integer.parseInt(ballNumber);
    } catch (final NumberFormatException e) {
      throw new IllegalArgumentException("BallNumber는 반드시 숫자여야 합니다.");
    }
  }
}
