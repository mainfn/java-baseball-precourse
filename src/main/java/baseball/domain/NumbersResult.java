package baseball.domain;

public final class NumbersResult {

  private final int ballCount;
  private final int strikeCount;

  public NumbersResult(
      final int ballCount,
      final int strikeCount
  ) {
    this.ballCount = ballCount;
    this.strikeCount = strikeCount;
  }

  public static NumbersResult from(
      final Numbers answer,
      final Numbers guess
  ) {
    int ballCount = 0;
    int strikeCount = 0;

    for (int i = 0; i < 3; i++) {
      final boolean isStrike = answer.comparesAt(i, guess);
      if (isStrike) {
        strikeCount++;
        continue;
      }
      answer.containsAt(i, guess);
      ballCount++;
    }

    return new NumbersResult(ballCount, strikeCount);
  }

}