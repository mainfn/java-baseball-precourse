package baseball2.domain;

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

    for (int i = 0; i < 3; i++) {
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

  public static boolean isStrikeAt(
      final int index,
      final BaseBallRecord guess,
      final BaseBallRecord answer
  ) {
    return answer.comparesAt(index, guess);
  }

  public static boolean isBallAt(
      final int index,
      final BaseBallRecord guess,
      final BaseBallRecord answer
  ) {
    return answer.containsAt(index, guess);
  }

  public int getBallCount() {
    return ballCount;
  }

  public int getStrikeCount() {
    return strikeCount;
  }

  public boolean isThreeStrike() {
    return strikeCount == 3;
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
}
