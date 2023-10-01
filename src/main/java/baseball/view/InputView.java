package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public final class InputView {
  public static String inputBallNumber() {
    System.out.print("숫자를 입력해주세요 : ");
    return readLine();
  }

  private static String readLine() {
    return Console.readLine().trim();
  }
}
