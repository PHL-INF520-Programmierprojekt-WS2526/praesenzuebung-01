package de.phl.programmingproject.raccoon;

public class RaccoonForestApp {

    public static void main(String[] args) {
        Forest forest = new Forest("Enchanted Woods", 3);

        Raccoon bandit = new Raccoon("Bandit", "gray", 5000);
        Raccoon shadow = new Raccoon("Shadow", "obsidian", 4800);

        System.out.println(bandit.getInfo());
        System.out.println(shadow.getInfo());

        forest.addRaccoon(bandit);
        forest.addRaccoon(shadow);
        System.out.println(forest.getInfo());

        Food berries = new Food("Berries", 300);
        Food fish = new Food("Fish", 700);

        bandit.eat(berries);
        System.out.println(bandit.getInfo());
        shadow.eat(fish);
        System.out.println(shadow.getInfo());

    }
}
