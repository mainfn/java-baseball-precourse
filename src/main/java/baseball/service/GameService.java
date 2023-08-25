package baseball.service;

import baseball.domain.BaseBallRecord;
import baseball.domain.BaseBallResult;

public final class GameService {


  public GameService() {
  }

  public BaseBallResult getResult(
      final BaseBallRecord guess,
      final BaseBallRecord answer
  ) {
    return BaseBallResult.from(guess, answer);
  }
}
