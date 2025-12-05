package de.phl.programmingproject.dnd;

/**
 * This class represents a monster in a Dungeons & Dragons game.
 */
public class Monster {
    private final String name;
    private int hitPoints;
    private int strength;
    private Status status = Status.ALIVE;

    public Monster(final String name, final int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
    }


    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public Status getStatus() {
        return status;
    }

    public int getStrength() {
        return strength;
    }

    /**
     * Reduces the monster's hit points by the specified damage amount.
     * @param damage
     */
    public void takeDamage(int damage) {
        // TODO: implement your code here.
    }

    /**
     * Attacks the specified character.
     * @param player
     */
    public void attack(Player player) {
        player.takeDamage(this.strength);
    }


}
