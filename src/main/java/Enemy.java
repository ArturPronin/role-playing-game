abstract class Enemy implements Mortal {
    private String name;
    private int health;

    Enemy(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void takeDamage(int damage) {
        if (this.isAlive()) {
            health = Math.max(0, health - damage);
        }
    }

    @Override
    public boolean isAlive() {
        if (getHealth() > 0) {
            return true;
        } else {
            setHealth(0);
            System.out.println(this.name + " мертв!");
            return false;
        }
    }

    abstract public void attackHero(Hero hero);

}
