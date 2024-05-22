public class BattleGround {

    public static void main(String[] args) {

        Hero archer = new Archer("Лучник");
        Hero mage = new Mage("Маг");
        Hero warrior = new Warrior("Воин");

        Enemy zombie = new Zombie(100);
        Enemy ghost = new Ghost(80);
        Enemy dragon = new Dragon(150);

        int i=0;
        while (i <= 3) {
            i++;
            System.out.println("===== Раунд: " + i + " =====");
            warrior.attackEnemy(zombie);
            mage.attackEnemy(dragon);
            archer.attackEnemy(ghost);

            ghost.attackHero(archer);
            dragon.attackHero(mage);
            zombie.attackHero(warrior);

            System.out.println("Здоровье " + warrior.getName() + " = " + warrior.getHealth());
            System.out.println("Здоровье " + mage.getName() + " = " + mage.getHealth());
            System.out.println("Здоровье " + archer.getName() + " = " + archer.getHealth());

            System.out.println("Здоровье " + zombie.getName() + " = " + zombie.getHealth());
            System.out.println("Здоровье " + dragon.getName() + " = " + dragon.getHealth());
            System.out.println("Здоровье " + ghost.getName() + " = " + ghost.getHealth());

            System.out.println("===== Конец " + i + " раунда =====");
            System.out.println();
        }


    }
}
