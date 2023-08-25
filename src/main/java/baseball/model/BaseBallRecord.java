package baseball.model;

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

  // List.of(1,2,3); ->

  // arr = new ArrayList();
  // arr.add(1);
  // arr.add(2);
  // arr.add(3);

  // BaseBallRecord.of(1,2,3,4,5,6,7,8,9,0);

//  public static BaseBallRecord of(int... numbers) {
//    // [1,2,3,4,5,6,7,8,9,0]
//    return new BaseBallRecord(
//        numbers[0],
//        numbers[1],
//        numbers[2]
//    );
//  }

  // BaseBallRecord.of(  [1,2,3,4,5,6,7,8,9,0]   );

  public static BaseBallRecord from(Integer[] numbers) {
    validateNumbers(numbers);
    for (final Integer number : numbers) {
      validateNumber(number);
    }
    return new BaseBallRecord(
        numbers[0],
        numbers[1],
        numbers[2]
    );
  }

  private static void validateNumbers(Integer[] numbers) {
    if (numbers.length != 3) {
      throw new IllegalArgumentException(
          "BaseBallRecord.from에 사용될 numbers Array는 반드시 length가 3이어야 한답니다^^");
    }
  }

  private static void validateNumber(Integer number) {
    if (number == null || number < 1 || number > 9) {
      throw new IllegalArgumentException("BaseBallRecord에 들어갈 숫자는 1~9 범위만 가능합니다.");
    }
  }

  public int getFirst() {
    return first;
  }

  public int getSecond() {
    return second;
  }

  public int getThird() {
    return third;
  }
}
