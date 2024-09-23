package game;

interface Weapon {
    void use();
}

interface PowerUp {
    void activate();
}

class Sword implements Weapon {
    public void use() {
        System.out.println("Swinging a sword.");
    }
}

class Shield implements Weapon {
    public void use() {
        System.out.println("Using a shield.");
    }
}

class HealthPotion implements PowerUp {
    public void activate() {
        System.out.println("Health restored.");
    }
}

class SpeedBoost implements PowerUp {
    public void activate() {
        System.out.println("Speed increased.");
    }
}

class GameFactory {
    public Weapon createWeapon(String type) {
        switch (type.toLowerCase()) {
            case "sword":
                return new Sword();
            case "shield":
                return new Shield();
            default:
                throw new IllegalArgumentException("Unknown weapon type.");
        }
    }

    public PowerUp createPowerUp(String type) {
        switch (type.toLowerCase()) {
            case "healthpotion":
                return new HealthPotion();
            case "speedboost":
                return new SpeedBoost();
            default:
                throw new IllegalArgumentException("Unknown power-up type.");
        }
    }
}
