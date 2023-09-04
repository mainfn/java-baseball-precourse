package baseball.view;

import baseball.domain.NumbersResult;

public final class OutputView {

  public void printInputNumbersMessage() {
    System.out.print(Message.INPUT_NUMBERS);
  }

  public void printGameClearMessage() {
    System.out.println(Message.GAME_CLEAR);
  }

  public void printGameResult(final NumbersResult result) {
    System.out.println(result);
  }
}
