package baseball.controller;

public final class InputValidator {

  public static void validateBallNumberFormat(final String ballNumber) {
    try {
      Integer.parseInt(ballNumber);
    } catch (final NumberFormatException e) {
      throw new IllegalArgumentException("BallNumber는 반드시 숫자여야 합니다.");
    }
  }
}
