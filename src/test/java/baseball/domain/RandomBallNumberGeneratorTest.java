package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomBallNumberGeneratorTest {

  private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator(1, 9);

  @DisplayName("항상 서로 다른 3자리 숫자를 생성한다.")
  @Test
  void test() {
    // given
    final RandomBallNumberGenerator randomBallNumberGenerator = new RandomBallNumberGenerator(
        randomNumberGenerator);

    for (int i = 0; i < 1_000_000; i++) {
      // when
      final BallNumber ballNumber = randomBallNumberGenerator.generate();
      final int first = ballNumber.getFirst();
      final int second = ballNumber.getSecond();
      final int third = ballNumber.getThird();

      // then
      assertThat(first).isNotEqualTo(second);
      assertThat(second).isNotEqualTo(third);
      assertThat(third).isNotEqualTo(first);
      assertThat(second).isNotEqualTo(first);
    }
  }
}