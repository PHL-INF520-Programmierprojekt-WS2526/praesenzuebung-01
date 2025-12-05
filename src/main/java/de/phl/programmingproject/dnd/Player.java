package de.phl.programmingproject.dnd;

/**
 * This class represents a character in a Dungeons & Dragons game.
 */
public class Player {


    private final String name;
    private final CharacterClass characterClass;
    private int hitPoints;
    private Status status = Status.ALIVE;

    public Player(final String name, final CharacterClass characterClass, int hitPoints) {
        this.name = name;
        this.characterClass = characterClass;
        this.hitPoints = hitPoints;
    }

    public Status getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    /**
     * Attacks the specified monster and returns a string describing the attack.
     * @param monster The monster to attack.
     * @return A string describing the attack.
     */
    public String attack(Monster monster){
        // TODO: implement your code here.
        return null;
    }

    /**
     * Reduces the character's hit points by the specified damage amount.
     * @param damage The amount of damage to take.
     */
    public void takeDamage(int damage) {
        // TODO: implement your code here
    }
}
