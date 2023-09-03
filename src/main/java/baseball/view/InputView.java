package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public final class InputView {

  private final OutputView outputView;

  public InputView(final OutputView outputView) {
    this.outputView = outputView;
  }

  public Integer inputNumbers() {
    try {
      return Integer.parseInt(readLine());
    } catch (final Exception e) {
      throw new IllegalArgumentException("잘못된 입력입니다. 숫자를 입력해주세요.");
    }
  }

  public boolean inputRestartOrQuit() {
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
