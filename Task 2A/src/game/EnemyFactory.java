package game;

interface Enemy {
    void attack();
}

class Goblin implements Enemy {
    public void attack() {
        System.out.println("Goblin attacks!");
    }
}

class Orc implements Enemy {
    public void attack() {
        System.out.println("Orc attacks!");
    }
}

class EnemyFactory {
    public Enemy createEnemy(String type) {
        switch (type.toLowerCase()) {
            case "goblin":
                return new Goblin();
            case "orc":
                return new Orc();
            default:
                throw new IllegalArgumentException("Unknown enemy type.");
        }
    }
}
