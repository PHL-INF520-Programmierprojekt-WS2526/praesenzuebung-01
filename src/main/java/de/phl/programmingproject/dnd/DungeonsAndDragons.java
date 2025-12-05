package de.phl.programmingproject.dnd;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a Dungeons & Dragons game.
 */
public class DungeonsAndDragons {

    public static void main(String[] args) {
        // TODO: implement your code here
    }

    public static void fight(Player player, Monster monster) {
        // TODO: implement your code here
    }

    public static String[] names = {
            "Goblin", "Orc", "Troll", "Dragon", "Zombie",
            "Vampire", "Werewolf", "Giant Spider", "Skeleton", "Demon",
            "Slime", "Ghost", "Harpy", "Minotaur", "Hydra",
            "Lich", "Mimic", "Banshee", "Kobold", "Gnoll"
    };

    /**
     * Creates a list of 20 monsters.
     *
     * @return
     */
    public static List<Monster> createMonsters() {
        List<Monster> monsters = new ArrayList<>(20);
        // TODO: implement your code here

        return monsters;
    }
}
