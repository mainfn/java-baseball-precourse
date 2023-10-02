package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class BallNumber {

  private final List<Integer> ballNumbers;

  private BallNumber(final List<Integer> ballNumbers) {
    validateBallNumbers(ballNumbers);
    this.ballNumbers = ballNumbers;
  }

  public static BallNumber of(final List<Integer> ballNumbers) {
    return new BallNumber(ballNumbers);
  }

  public static BallNumber from(final String ballNumbersString) {
    final List<Integer> ballNumbers = new ArrayList<>();

    for (final String ballNumberString : ballNumbersString.split("")) {
      final int ballNumber = Integer.parseInt(ballNumberString);
      ballNumbers.add(ballNumber);
    }

    return new BallNumber(ballNumbers);
  }

  private static void validateBallNumbers(final List<Integer> ballNumbers) {
    validateBallNumbersLength(ballNumbers);
    validateBallNumbersDuplication(ballNumbers);
  }

  private static void validateBallNumbersLength(final List<Integer> ballNumbers) {
    if (ballNumbers.size() != 3) {
      throw new IllegalArgumentException("BallNumbers는 반드시 3개의 숫자로 이루어져야 합니다.");
    }
  }

  private static void validateBallNumbersDuplication(final List<Integer> ballNumbers) {
    final Set<Integer> ballNumbersSet = new HashSet<>(ballNumbers);

    if (ballNumbersSet.size() != 3) {
      throw new IllegalArgumentException("BallNumbers의 숫자는 중복될 수 없습니다.");
    }
  }

  public boolean comparesAt(final int index, final BallNumber other) {
    return this.ballNumbers.get(index) == other.ballNumbers.get(index);
  }

  public boolean containsAt(final int index, final BallNumber other) {
    return this.ballNumbers.contains(other.ballNumbers.get(index));
  }

  public int getFirst() {
    return ballNumbers.get(0);
  }

  public int getSecond() {
    return ballNumbers.get(1);
  }

  public int getThird() {
    return ballNumbers.get(2);
  }
}
