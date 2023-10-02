package baseball.domain;

public final class GuessResult {

  private final int strikeCount;
  private final int ballCount;

  public GuessResult(final int strikeCount, final int ballCount) {
    this.strikeCount = strikeCount;
    this.ballCount = ballCount;
  }

  public static GuessResult of(final int strikeCount, final int ballCount) {
    return new GuessResult(strikeCount, ballCount);
  }

  public boolean isThreeStrikes() {
    return strikeCount == 3;
  }

  public String toString() {
    if (ballCount + strikeCount == 0) {
      return "낫싱";
    }

    final StringBuilder sb = new StringBuilder();
    if (ballCount > 0) {
      sb.append(ballCount).append("볼 ");
    }
    if (strikeCount > 0) {
      sb.append(strikeCount).append("스트라이크");
    }
    return sb.toString();
  }
}
