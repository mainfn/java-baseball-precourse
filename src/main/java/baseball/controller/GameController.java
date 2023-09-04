package baseball.controller;

import baseball.domain.Numbers;
import baseball.domain.NumbersResult;
import baseball.service.GameService;
import baseball.util.RandomNumbersGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

public final class GameController {

  private final InputView inputView;
  private final OutputView outputView;
  private final RandomNumbersGenerator randomNumbersGenerator;

  private final GameService gameService;

  public GameController(
      final InputView inputView,
      final OutputView outputView,
      final RandomNumbersGenerator randomNumbersGenerator,
      final GameService gameService
  ) {
    this.inputView = inputView;
    this.outputView = outputView;
    this.randomNumbersGenerator = randomNumbersGenerator;
    this.gameService = gameService;
  }

  // controller/GameController.java


  public void start() {

    boolean isPlaying = true;

    while (isPlaying) {
      play();
      // 1을 입력한 경우 while 루프 재실행
      // 2를 입력한 경우 종료
      isPlaying = inputView.inputRestart();
    }
  }

  private void play() {

    // 정답 숫자 생성
    final Numbers answer = randomNumbersGenerator.generateNumbers();

    while (true) {
      // 사용자 입력 받아서 숫자 생성
      final Numbers guess = inputView.inputNumbers();

      // 입력과 정답 비교하여 결과 반환
      final NumbersResult gameResult = gameService.getGameResult(answer, guess);

      // 결과 출력
      outputView.printGameResult(gameResult);

      // 정답인 경우 반환
      if (gameResult.isThreeStrike()) {
        return;
      }
    }
  }
}
