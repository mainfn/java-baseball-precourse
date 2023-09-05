package baseball.service;

import baseball.domain.Numbers;
import baseball.domain.NumbersResult;

public final class GameService {

  public NumbersResult getGameResult(final Numbers answer, final Numbers guess) {
    return NumbersResult.from(answer, guess);
  }
}
