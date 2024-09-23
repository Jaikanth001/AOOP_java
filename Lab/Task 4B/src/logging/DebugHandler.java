package logging;

public class DebugHandler extends LogHandler {
    @Override
    public void handle(String message) {
        if (message.startsWith("DEBUG")) {
            System.out.println("DEBUG: " + message);
        } else if (nextHandler != null) {
            nextHandler.handle(message);
        }
    }
}
