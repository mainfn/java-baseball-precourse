package baseball2.view;

import baseball2.domain.AnswerKind;
import baseball2.domain.BaseBallResult;

public final class GameView {

  public AnswerKind render(final BaseBallResult baseBallResult) {

    final int ballCount = baseBallResult.getBallCount();
    final int strikeCount = baseBallResult.getStrikeCount();

    if (ballCount > 0) {
      System.out.printf("%d볼 ", ballCount);
    }
    if (strikeCount > 0) {
      System.out.printf("%d스트라이크", strikeCount);
    }
    if (ballCount == 0 && strikeCount == 0) {
      System.out.print("낫싱");
    }

    if (baseBallResult.isThreeStrike()) {
      return AnswerKind.CORRECT;
    }

    System.out.println();

    return AnswerKind.WRONG;
  }

}
