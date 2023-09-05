package baseball.domain;

import java.util.ArrayList;
import java.util.List;

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
      final boolean isBall = answer.containsAt(i, guess);
      if (isBall) {
        ballCount++;
      }
    }

    return new NumbersResult(ballCount, strikeCount);
  }

  public boolean isThreeStrike() {
    return strikeCount == 3;
  }

  @Override
  public String toString() {

    if (ballCount == 0 && strikeCount == 0) {
      return "낫싱";
    }

    final List<String> strs = new ArrayList<>();

    if (ballCount > 0) {
      strs.add(String.format("%d볼", ballCount));
    }

    if (strikeCount > 0) {
      strs.add(String.format("%d스트라이크", strikeCount));
    }

    return String.join(" ", strs);

  }


}