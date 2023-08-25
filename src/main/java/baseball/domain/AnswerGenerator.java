package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public final class AnswerGenerator {


  private final RandomNumberGenerator randomNumberGenerator;

  public AnswerGenerator(final RandomNumberGenerator randomNumberGenerator) {
    this.randomNumberGenerator = randomNumberGenerator;
  }

  public BaseBallRecord generate() {
    final Set<Integer> numberSet = new HashSet<>();

    while (numberSet.size() < 3) {
      final int number = randomNumberGenerator.generate();
      numberSet.add(number);
    }

    return BaseBallRecord.from(new ArrayList<>(numberSet));
  }
}
