package baseball.domain;

public final class GameManager {

  private final BallNumber answer;

  public GameManager(final BallNumber answer) {
    this.answer = answer;
  }


  public GuessResult guess(final BallNumber guess) {
    int strikeCount = 0;
    int ballCount = 0;

    for (int i = 0; i < 3; i++) {
      if (isStrike(guess, i)) {
        strikeCount++;
      } else if (isBall(guess, i)) {
        ballCount++;
      }
    }
    return GuessResult.of(strikeCount, ballCount);
  }

  private boolean isBall(final BallNumber guess, final int index) {
    return this.answer.containsAt(index, guess);
  }

  private boolean isStrike(final BallNumber guess, final int index) {
    return this.answer.comparesAt(index, guess);
  }
}
