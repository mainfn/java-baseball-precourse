package baseball2.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class BaseBallRecord {

  private final int first;
  private final int second;
  private final int third;

  public BaseBallRecord(
      final int first,
      final int second,
      final int third
  ) {
    this.first = first;
    this.second = second;
    this.third = third;
  }

  public static BaseBallRecord from(final List<Integer> numbers) {
    validateNumbers(numbers);
    return new BaseBallRecord(
        numbers.get(0),
        numbers.get(1),
        numbers.get(2)
    );
  }

  public static BaseBallRecord from(final String numberString) {
    return BaseBallRecord.from(
        Arrays.stream(numberString.split(""))
            .map(Integer::parseInt)
            .collect(Collectors.toList())
    );
  }

  private static void validateNumbers(final List<Integer> numbers) {
    if (numbers.size() != 3) {
      throw new IllegalArgumentException(
          "BaseBallRecord.from에 사용될 numbers List는 반드시 size가 3이어야 한답니다^^");
    }

    numbers.forEach(BaseBallRecord::validateNumber);
  }

  private static void validateNumber(final Integer number) {
    if (number == null || number < 1 || number > 9) {
      throw new IllegalArgumentException("BaseBallRecord에 들어갈 숫자는 1~9 범위만 가능합니다.");
    }
  }

  public boolean containsAt(
      final int index,
      final BaseBallRecord other
  ) {
    Integer otherNumber = other.getAt(index);
    return this.toList().contains(otherNumber);
  }

  public boolean comparesAt(
      final int index,
      final BaseBallRecord other) {
    Integer expect = this.getAt(index);
    Integer guess = other.getAt(index);
    return expect.equals(guess);
  }

  private List<Integer> toList() {
    return Arrays.asList(first, second, third);
  }

  private Integer getAt(final int index) {
    return this.toList().get(index);
  }
}
