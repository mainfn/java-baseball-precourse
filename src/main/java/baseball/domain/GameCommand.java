package baseball.domain;

public enum GameCommand {
  RESTART("1"),
  EXIT("2");

  private final String command;

  GameCommand(final String command) {
    this.command = command;
  }

  public static GameCommand of(final String command) {
    if ("1".equals(command)) {
      return RESTART;
    }
    if ("2".equals(command)) {
      return EXIT;
    }
    throw new IllegalArgumentException("유효하지 않은 enum constant value");
  }
}
