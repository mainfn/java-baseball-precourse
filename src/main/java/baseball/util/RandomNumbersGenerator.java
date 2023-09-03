package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class RandomNumbersGenerator {

  private final int startInclusive;
  private final int endInclusive;

  public RandomNumbersGenerator(
      final int startInclusive,
      final int endInclusive
  ) {
    this.startInclusive = startInclusive;
    this.endInclusive = endInclusive;
  }

  public List<Integer> generateNumbers() {
    final Set<Integer> numbers = new HashSet<>();
    while (numbers.size() < 3) {
      numbers.add(generateNumber());
    }
    return new ArrayList<>(numbers);
  }

  private boolean isDuplicate(final List<Integer> numbers, final Integer newNumber) {
    for (final Integer number : numbers) {
      if (number.equals(newNumber)) {
        return true;
      }
    }
    return false;
  }

  private int generateNumber() {
    return Randoms.pickNumberInRange(startInclusive, endInclusive);
  }
}
