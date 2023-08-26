package baseball.view;

import baseball.domain.AnswerKind;
import baseball.domain.BaseBallResult;

public final class GameView {

  public AnswerKind render(final BaseBallResult baseBallResult) {
    System.out.println(baseBallResult.toString());

    if (baseBallResult.isThreeStrike()) {
      return AnswerKind.CORRECT;
    }
    return AnswerKind.WRONG;
  }

}
