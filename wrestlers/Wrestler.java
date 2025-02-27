package wrestlers;

import utils.Timer;

public class Wrestler {
    private String name;
    private int weight;
    private int health;
    private int initialHealth;
    private int power;
    private int points;

    private Wrestler(WrestlerBuilder builder) {
        this.name = builder.name;
        this.weight = builder.weight;
        this.health = builder.health;
        this.initialHealth = builder.health;
        this.points = builder.points;
        this.power = builder.power;
    }

    public String getName() {
        return this.name;
    }

    public int getWeight() {
        return this.weight;
    }

    public int getHealth() {
        return this.health;
    }

    public int getPoints() {
        return this.points;
    }

    public void setPoints(int points) {
        this.points += points;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void performMove(Wrestler opponent) {
        if (this.health > 10) {
            int damage = Math.max(5, this.power - 5);
            opponent.setHealth(opponent.getHealth() - damage);
            Timer.waitForSeconds(1);

            // refactor it to a little small statement like a arrow
            System.out.println(
                    this.name + " dealt damage -> " + damage + " damage.");

            // add spaces after winners and loosers.
            // observe the order of fight, nned to know how threads execute and how multiple
            // of them execute.
            // display a table of points

        } else {
            Timer.waitForSeconds(1);
            System.out.println(this.name + " is too weak to attack.");
        }
    }

    public boolean isEliminated() {
        if (this.health <= 0) {
            System.out.println(this.name + " is Eliminated.");
            return true;
        }
        return false;
    }

    public void SpecialMove(Wrestler opponent) {
        if (this.health > 10) {
            int damage = this.power;
            opponent.setHealth(opponent.getHealth() - damage);
            Timer.waitForSeconds(1);

            System.out.println(this.name + " unleashes a POWER MOVE on " + opponent.getName() + "!");
        } else {
            Timer.waitForSeconds(1);
            System.out.println(this.name + " is too weak to perform Special Move");
        }
    }

    public void resetHealth() {
        this.health = this.initialHealth;
    }

    public static class WrestlerBuilder {
        private String name;
        private int weight;
        private int health;
        private int points;
        private int power;

        public WrestlerBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public WrestlerBuilder setHealth(int health) {
            this.health = health;
            return this;
        }

        public WrestlerBuilder setWeight(int weight) {
            this.weight = weight;
            return this;
        }

        public WrestlerBuilder setPower(int power) {
            this.power = power;
            return this;
        }

        public Wrestler build() {
            return new Wrestler(this);
        }
    }
}
