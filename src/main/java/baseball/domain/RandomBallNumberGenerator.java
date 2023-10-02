package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;

public final class RandomBallNumberGenerator {

  private final RandomNumberGenerator randomNumberGenerator;

  public RandomBallNumberGenerator(final RandomNumberGenerator randomNumberGenerator) {
    this.randomNumberGenerator = randomNumberGenerator;
  }

  public BallNumber generate() {
    final HashSet<Integer> numbers = new HashSet<>();
    while (numbers.size() < 3) {
      final int number = randomNumberGenerator.generate();
      numbers.add(number);
    }

    return BallNumber.of(new ArrayList<>(numbers));
  }
}
