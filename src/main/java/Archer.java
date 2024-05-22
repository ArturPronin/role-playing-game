/**
 * Особенность лучника: Становится бессметрным, если попадает из лука 5 раз подряд (его попадания рандомны и вероятность попадания 75%)
 * Однако, он будет бессметрным до того момента, пока снова не промахнется из лука.
 */
public class Archer extends Hero {
    private int damage;
    private int hitStreak;
    private boolean isImmortal;

    Archer(String name) {
        super(name);
        this.damage = 15;
        this.hitStreak = 0;
        this.isImmortal = false;
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        if (enemy.getClass() == Ghost.class) {
            System.out.println("Только маг может нанести урон Призраку!");
        } else if (!this.isAlive()) {
            System.out.println(this.getName() + ", Вы погибли и не можете атаковать!");
        } else if (!enemy.isAlive()) {
            System.out.println(enemy.getName() + " уже погиб!");
        } else {
            int random = 1 + (int) (Math.random() * 4); // 75% шанс попадания
            if (random <= 3) {
                enemy.takeDamage(damage);
                System.out.println(this.getName() + " атаковал " + enemy.getName() + " стрелой на " + damage + " урона!");
                hitStreak++;
                if (hitStreak >= 5) {
                    isImmortal = true;
                    System.out.println(getName() + " стал бессмертным!");
                }
            } else {
                System.out.println(this.getName() + " промахнулся!");
                hitStreak = 0;
                isImmortal = false;
            }
        }
    }

    public boolean isImmortal() {
        return isImmortal;
    }

    @Override
    public void takeDamage(int damage) {
        if (isImmortal) {
            System.out.println(getName() + " бессмертен и не получает урон!");
        } else {
            super.takeDamage(damage);
        }
    }
}
