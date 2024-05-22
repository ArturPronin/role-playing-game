/**
 * Особенности дракона: Рандомно выпускает пламя, наносящее x3 урона
 */
public class Dragon extends Enemy {
    private int damage;

    public Dragon(int health) {
        super(health);
        this.setName("Дракон");
        this.damage = 50;
    }

    @Override
    public void attackHero(Hero hero) {
        int random = 1 + (int) (Math.random() * 6);

        if (hero.isAlive() && this.isAlive()) {
            if (hero instanceof Archer && ((Archer) hero).isImmortal()) {
                System.out.println(hero.getName() + " бессмертен и не получает урон!");
            } else {
                if (random == 3) {
                    System.out.println(this.getName() + " выпустил пламя и поджог " + hero.getName() + " на " + damage * 3 + " урона!");
                    hero.takeDamage(damage * 3);
                } else {
                    System.out.println(hero.getName() + " атакован " + this.getName() + " на " + damage + " урона!");
                    hero.takeDamage(damage);
                }
            }
        } else if (this.isAlive()) {
            System.out.println("Герой " + hero.getName() + " уже погиб!");
        } else {
            System.out.println(this.getName() + " уже погиб и не может атаковать!");
        }
    }
}