package de.phl.programmingproject.raccoon;

/**
 * A simple Food class with name and weight attributes.
 */
public class Food {

    private String name;
    private int weight;

    /**
     * Creates a new Food instance with the given name and weight.
     * @param name
     * @param weight
     */
    public Food(String name, int weight) {
        if( name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name must not be null or empty");
        }
        if(weight <= 0) {
            throw new IllegalArgumentException("Weight must be positive");
        }
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    /**
     * Consumes the food, setting its weight to zero and returning the weight gained from consuming the food.
     * @return The weight gained from consuming the food.
     */
    public int consume(){
        int gainedWeight = this.weight / 2;
        this.weight = 0;
        return gainedWeight;
    }

    /**
     * Gets information about the food.
     * @return
     */
    public String getInfo() {
        return String.format("Food Name: %s, Weight: %dg", name, weight);
    }


}
