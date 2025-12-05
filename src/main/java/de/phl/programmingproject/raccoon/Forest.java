package de.phl.programmingproject.raccoon;

import java.util.LinkedList;
import java.util.List;

/**
 * A Forest class with a name and capacity, containing a list of raccoons.
 */
public class Forest {

    private String name;
    private int capacity;
    public List<Raccoon> raccoons = new LinkedList<>();

    /**
     * Creates a new Forest instance with the given name and capacity.
     * @param name
     * @param capacity
     */
    public Forest(final String name, final int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    /**
     * Gets the list of raccoons living in the forest.
     * @return
     */
    public List<Raccoon> getRaccoons() {
        return raccoons;
    }

    /**
     * Adds a raccoon to the forest if capacity allows.
     * @param raccoon
     */
    public void addRaccoon(Raccoon raccoon) {
        if(raccoons.size() >= capacity) {
           throw new IllegalStateException("Forest is at full capacity!");
        }
        raccoons.add(raccoon);
    }

    /**
     * Gets information about the forest and its raccoons.
     * @return
     */
    public String getInfo(){
        return String.format("Forest Name: %s, Capacity: %d, Current Raccoons: %d", name, capacity, raccoons.size());
    }
}
