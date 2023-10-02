package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameManagerTest {

  @DisplayName("answer와 guess의 숫자가 모두 일치하면 isThreeStrikes는 true를 반환한다.")
  @Test
  void isThreeStrikes() {
    // given
    final BallNumber answer = BallNumber.of(
        Arrays.asList(1, 2, 3)
    );
    final GameManager gameManager = new GameManager(answer);
    final BallNumber guess = answer;

    // when
    final GuessResult guessResult = gameManager.guess(guess);

    // then
    assertThat(guessResult.isThreeStrikes()).isTrue();
  }

  @DisplayName("숫자와 index가 모두 일치하면 스트라이크로 집계된다.")
  @Test
  void oneStrike() {
    // given
    final BallNumber answer = BallNumber.from("123");
    final GameManager gameManager = new GameManager(answer);
    final BallNumber guess = BallNumber.from("189");

    // when
    final GuessResult guessResult = gameManager.guess(guess);

    // then
    assertThat(guessResult.toString()).isEqualTo("1스트라이크");
  }

  @DisplayName("숫자가 일치하고 index가 다르면 볼로 집계된다.")
  @Test
  void oneBall() {
    // given
    final BallNumber answer = BallNumber.from("123");
    final GameManager gameManager = new GameManager(answer);
    final BallNumber guess = BallNumber.from("891");

    // when
    final GuessResult guessResult = gameManager.guess(guess);

    // then
    assertThat(guessResult.toString().trim()).isEqualTo("1볼");
  }

  @DisplayName("볼과 스트라이크가 1개씩 존재하는 경우")
  @Test
  void oneBallOneStrike() {
    // given
    final BallNumber answer = BallNumber.from("123");
    final GameManager gameManager = new GameManager(answer);
    final BallNumber guess = BallNumber.from("192");

    // when
    final GuessResult guessResult = gameManager.guess(guess);

    // then
    assertThat(guessResult.toString().trim()).isEqualTo("1볼 1스트라이크");
  }

  @DisplayName("아무 것도 일치하지 않는 경우 낫싱")
  @Test
  void nothing() {
    // given
    final BallNumber answer = BallNumber.from("123");
    final GameManager gameManager = new GameManager(answer);
    final BallNumber guess = BallNumber.from("789");

    // when
    final GuessResult guessResult = gameManager.guess(guess);

    // then
    assertThat(guessResult.toString()).isEqualTo("낫싱");
  }

}