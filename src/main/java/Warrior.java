/**
 * Особенность воина: Выпиваеет зелье для восстановления 50 ед. здоровья, если у него осталось менее 35 ед. здоровья.
 * (будет выпивать зелье, только если вызвать метод isAlive() у объекта Warrior, когда у него менее 35 ед. здоровья)
 */
public class Warrior extends Hero {
    private int damage;

    Warrior(String name) {
        super(name);
        this.damage = 30;
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        if (enemy.getClass() == Ghost.class) {
            System.out.println("Только маг может нанести урон Призраку!");
        } else if (enemy.isAlive() && this.isAlive()) {
            enemy.takeDamage(damage);
            System.out.println(this.getName() + " атаковал " + enemy.getName() + " мечом на " + damage + " урона!");
        } else if (this.isAlive()) {
            System.out.println(enemy.getName() + " уже погиб!");
        } else {
            System.out.println(this.getName() + ", Вы погибли и не можете атаковать!");
        }
    }

    public void takePotion(int health) {
        this.setHealth(50);
        System.out.println(this.getName() + " выпил зелье здоровья, так как у него осталось меньше 35 ед.");
    }


    @Override
    public boolean isAlive() {
        if (this.getHealth() > 0) {
            if (this.getHealth() < 35) {
                takePotion(this.getHealth());
                return true;
            } else {
                return true;
            }
        } else {
            this.setHealth(0);
            return false;
        }
    }

}
