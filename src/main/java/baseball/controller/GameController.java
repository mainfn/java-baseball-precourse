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

  public void start() {
    // 정답 숫자 생성
    final Numbers answer = randomNumbersGenerator.generateNumbers();

    // 정답을 맞추고 게임 종료 시 루프 탈출
    while (true) {
      // 사용자 입력 받아서 숫자 생성
      final Numbers guess = inputView.inputNumbers();

      // 입력과 정답 비교하여 결과 반환
      final NumbersResult gameResult = gameService.getGameResult(answer, guess);

      // 결과 출력

      // 정답인 경우 재시작, 게임 종료 중 사용자가 원하는 기능 수행
    }

  }
}
