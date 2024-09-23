package logging;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Logger {
    private final List<Command> commands = new ArrayList<>();

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void executeCommands() {
        Iterator<Command> iterator = commands.iterator();
        while (iterator.hasNext()) {
            iterator.next().execute("INFO: Sample log message"); // Example log message
        }
    }
}
