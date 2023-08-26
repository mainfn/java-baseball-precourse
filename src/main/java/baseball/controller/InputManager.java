package baseball.controller;

import baseball.domain.BaseBallRecord;
import camp.nextstep.edu.missionutils.Console;

public final class InputManager {

  private static final String INPUT_BALL_NUMBER_MESSAGE = "숫자를 입력해주세요";
  private static final String GAME_CLEAR_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

  public BaseBallRecord inputBaseBallRecord() {
    System.out.println(INPUT_BALL_NUMBER_MESSAGE);
    return BaseBallRecord.from(Console.readLine());
  }

  public boolean askQuit() {
    System.out.println(GAME_CLEAR_MESSAGE);
    return Integer.parseInt(Console.readLine()) == 2;
  }

}
