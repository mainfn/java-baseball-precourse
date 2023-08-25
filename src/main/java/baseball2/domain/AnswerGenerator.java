package baseball2.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public final class AnswerGenerator {


  private final RandomNumberGenerator randomNumberGenerator;

  public AnswerGenerator(final RandomNumberGenerator randomNumberGenerator) {
    this.randomNumberGenerator = randomNumberGenerator;
  }

  public BaseBallRecord generate() {
    Set<Integer> numberSet = new HashSet<>();

    while (numberSet.size() < 3) {
      int number = randomNumberGenerator.generate();
      numberSet.add(number);
    }

    return BaseBallRecord.from(new ArrayList<>(numberSet));
  }
}
