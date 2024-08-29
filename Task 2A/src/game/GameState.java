package game;

public class GameState {
    private static GameState instance;
    private String level;
    private String difficulty;

    private GameState() {}

    public static GameState getInstance() {
        if (instance == null) {
            instance = new GameState();
        }
        return instance;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public void displayState() {
        System.out.println("Level: " + level + ", Difficulty: " + difficulty);
    }
}
