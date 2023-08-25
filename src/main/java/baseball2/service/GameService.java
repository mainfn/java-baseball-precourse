package baseball2.service;

import baseball2.domain.AnswerGenerator;
import baseball2.domain.BaseBallRecord;
import baseball2.domain.BaseBallResult;

public final class GameService {

  private final AnswerGenerator answerGenerator;

  public GameService(final AnswerGenerator answerGenerator) {
    this.answerGenerator = answerGenerator;
  }

  public void run() {

  }

  public BaseBallResult getResult(
      final BaseBallRecord guess,
      final BaseBallRecord answer
  ) {
    return BaseBallResult.from(guess, answer);
  }
}
