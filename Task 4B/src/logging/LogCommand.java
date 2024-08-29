package logging;

public class LogCommand implements Command {
    private final LogHandler handler;

    public LogCommand(LogHandler handler) {
        this.handler = handler;
    }

    @Override
    public void execute(String message) {
        handler.handle(message);
    }
}
