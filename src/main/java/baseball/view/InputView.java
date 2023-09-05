package baseball.view;

import baseball.domain.Numbers;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class InputView {

  private final OutputView outputView;

  public InputView(final OutputView outputView) {
    this.outputView = outputView;
  }

  public Numbers inputNumbers() {
    outputView.printInputNumbersMessage();
    try {
      final List<Integer> numbers = Arrays.stream(readLine().split(""))
          .map(Integer::parseInt)
          .collect(Collectors.toList());

      return Numbers.of((numbers));
    } catch (final Exception e) {
      throw new IllegalArgumentException("잘못된 입력입니다. 숫자를 입력해주세요.");
    }
  }

  public boolean inputRestart() {

    outputView.printGameClearMessage();

    final String input = readLine();

    if ("1".equals(input)) {
      return true;
    }
    if ("2".equals(input)) {
      return false;
    }

    throw new IllegalArgumentException("잘못된 입력입니다. 1, 2 중 하나를 입력해주세요.");
  }

  private String readLine() {
    return Console.readLine().trim();
  }
}
