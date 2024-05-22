/**
 * Оснобенность зомби: Для него есть вероятность воскреснуть, если он умер
 */
public class Zombie extends Enemy {
    private int damage;

    public Zombie(int health) {
        super(health);
        setName("Зомби");
        this.damage = 30;
    }

    @Override
    public boolean isAlive() {
        int random = 1 + (int) (Math.random() * 4);

        if (getHealth() > 0) {
            return true;
        } else {
            if (random == 3) {
                setHealth(100);
                System.out.println("Зомби воскрес!");
                return true;
            } else {
                setHealth(0);
                return false;
            }
        }
    }

    @Override
    public void attackHero(Hero hero) {
        if (hero.isAlive() && this.isAlive()) {
            if (hero instanceof Archer && ((Archer) hero).isImmortal()) {
                System.out.println(hero.getName() + " бессмертен и не получает урон!");
            } else {
                System.out.println(this.getName() + " атаковал " + hero.getName() + " на " + damage + " урона!");
                hero.takeDamage(damage);
            }
        } else if (this.isAlive()) {
            System.out.println(hero.getName() + " уже погиб!");
        } else {
            System.out.println(this.getName() + " уже погиб и не может атаковать!");
        }
    }
}