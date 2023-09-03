package baseball.domain;

import java.util.List;

public final class Numbers {

  private final List<Integer> numbers;

  private Numbers(final List<Integer> numbers) {
    validateLength(numbers);
    validateRange(numbers);
    this.numbers = numbers;
  }

  public static Numbers of(final List<Integer> numbers) {
    return new Numbers(numbers);
  }

  private void validateLength(final List<Integer> numbers) {
    if (numbers.size() != 3) {
      throw new IllegalArgumentException("숫자는 3개여야 합니다.");
    }
  }

  private void validateRange(final List<Integer> numbers) {
    for (final Integer number : numbers) {
      if (number < 1 || number > 9) {
        throw new IllegalArgumentException("유효하지 않은 숫자가 있습니다.");
      }
    }
  }

  public boolean comparesAt(final int index, final Numbers other) {
    return numbers.get(index).equals(other.numbers.get(index));
  }

  public boolean containsAt(final int index, final Numbers other) {
    return numbers.contains(other.numbers.get(index));
  }
}
