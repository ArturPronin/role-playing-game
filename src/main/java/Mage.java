/**
 * Особенность мага: Рандомно использует разные заклинания стихий с различным количеством урона
 */
public class Mage extends Hero {
    private int damage;
    private String magicName;

    Mage(String name) {
        super(name);
    }

    public void differentMagic(int damage) {
        this.damage = 10;
        int random = (1 + (int) (Math.random() * 4));

        if (random == 1) {
            this.setMagicName("заклинанием Огня");
            this.damage *= 4;
        } else if (random == 2) {
            this.setMagicName("заклинанием Льда");
            this.damage *= 5;
        } else if (random == 3) {
            this.setMagicName("заклинанием Молнии");
            this.damage *= 8;
        } else if (random == 4) {
            this.setMagicName("заклинанием Камня");
            this.damage *= 9;
        } else {
            this.setMagicName("посохом");
            this.damage = damage;
        }

    }

    public String getMagicName() {
        return magicName;
    }

    public void setMagicName(String magicName) {
        this.magicName = magicName;
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        if (enemy.isAlive() && this.isAlive()) {
            differentMagic(damage);
            enemy.takeDamage(damage);
            System.out.println(this.getName() + " атаковал " + enemy.getName() + " " + this.getMagicName() + " на " + damage + " урона!");
        } else if (this.isAlive()) {
            System.out.println(enemy.getName() + " уже погиб!");
        } else {
            System.out.println(this.getName() + ", Вы погибли и не можете атаковать!");
        }
    }

}
