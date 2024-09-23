package game;

public class Main {
    public static void main(String[] args) {
        GameState gameState = GameState.getInstance();
        gameState.setLevel("1");
        gameState.setDifficulty("Easy");
        gameState.displayState();

        EnemyFactory enemyFactory = new EnemyFactory();
        Enemy enemy = enemyFactory.createEnemy("goblin");
        enemy.attack();

        GameFactory gameFactory = new GameFactory();
        Weapon weapon = gameFactory.createWeapon("sword");
        weapon.use();
        PowerUp powerUp = gameFactory.createPowerUp("healthpotion");
        powerUp.activate();
    }
}
