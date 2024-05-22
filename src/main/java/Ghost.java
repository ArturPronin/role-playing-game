/**
 * Особенность призрака: Может получать урон только от Мага.
 */
public class Ghost extends Enemy {
    private int damage = 40;

    public Ghost(int health) {
        super(health);
        setName("Призрак");
    }

    @Override
    public void attackHero(Hero hero) {
        if (hero.isAlive() && this.isAlive()) {
            if (hero instanceof Archer && ((Archer) hero).isImmortal()) {
                System.out.println(hero.getName() + " бессмертен и не получает урон!");
            } else {
                System.out.println(getName() + " высосал из " + hero.getName() + " жизни на " + damage + " урона!");
                hero.takeDamage(damage);
            }
        } else if (this.isAlive()) {
            System.out.println(hero.getName() + " уже погиб!");
        } else {
            System.out.println(getName() + " уже погиб и не может атаковать!");
        }
    }
}