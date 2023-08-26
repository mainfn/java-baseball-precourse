package baseball.domain;

import java.util.Objects;

public final class BaseBallResult {

  public static final BaseBallResult NOTHING = new BaseBallResult(0, 0);
  private final int ballCount;
  private final int strikeCount;

  private BaseBallResult(
      final int ballCount,
      final int strikeCount
  ) {
    this.ballCount = ballCount;
    this.strikeCount = strikeCount;
  }

  public static BaseBallResult from(
      final BaseBallRecord guess,
      final BaseBallRecord answer
  ) {
    int strikeCount = 0;
    int ballCount = 0;

    for (int i = 0; i < BaseBallRecord.NUMBERS_COUNT; i++) {
      if (isStrikeAt(i, guess, answer)) {
        strikeCount++;
        continue;
      }

      if (isBallAt(i, guess, answer)) {
        ballCount++;
      }
    }

    return new BaseBallResult(ballCount, strikeCount);

  }

  private static boolean isStrikeAt(
      final int index,
      final BaseBallRecord guess,
      final BaseBallRecord answer
  ) {
    return answer.comparesAt(index, guess);
  }

  private static boolean isBallAt(
      final int index,
      final BaseBallRecord guess,
      final BaseBallRecord answer
  ) {
    return answer.containsAt(index, guess);
  }


  public boolean isAllStrike() {
    return strikeCount == BaseBallRecord.NUMBERS_COUNT;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    BaseBallResult that = (BaseBallResult) object;
    return ballCount == that.ballCount && strikeCount == that.strikeCount;
  }

  @Override
  public int hashCode() {
    return Objects.hash(ballCount, strikeCount);
  }

  @Override
  public String toString() {
    if (ballCount + strikeCount == 0) {
      return "낫싱\n";
    }

    final StringBuilder sb = new StringBuilder();
    if (ballCount > 0) {
      sb.append(String.format("%d볼 ", ballCount));
    }
    if (strikeCount > 0) {
      sb.append(String.format("%d스트라이크", strikeCount));
    }
    sb.append("\n");
    return sb.toString();
  }
}

