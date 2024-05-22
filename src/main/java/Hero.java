abstract class Hero implements Mortal {
    private int health;
    private String name;

    Hero(String name) {
        this.name = name;
        this.setHealth(100);
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public void takeDamage(int damage) {
        if (this.isAlive()) {
            health = Math.max(0, health - damage);
        }
    }


    @Override
    public boolean isAlive() {
        if (this.getHealth() > 0) {
            return true;
        } else {
            this.setHealth(0);
            System.out.println(this.name + " мертв!");
            return false;
        }
    }

    abstract public void attackEnemy(Enemy enemy);

}
