package de.phl.programmingproject.raccoon;

/**
 * A simple Raccoon class with name, fur color, and weight attributes.
 */
public class Raccoon {
    private final String name;
    private final String furColor;
    private int weight;

    /**
     * Creates a new Raccoon instance with the given name, fur color, and weight.
     *
     * @param name
     * @param furColor
     * @param weight
     */
    public Raccoon(final String name, final String furColor, final int weight) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name must not be null or empty");
        }
        if (furColor == null || furColor.isEmpty()) {
            throw new IllegalArgumentException("Fur color must not be null or empty");
        }
        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be positive");
        }
        this.name = name;
        this.furColor = furColor;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public String getFurColor() {
        return furColor;
    }

    public int getWeight() {
        return weight;
    }

    /**
     * Makes the raccoon eat the given food, increasing its weight accordingly.
     *
     * @param food
     */
    public void eat(Food food) {
        this.weight += food.consume();
        System.out.printf("%s is eating %s, weighing %dg.%n", name, food.getName(), food.getWeight());
    }

    /**
     * Gets information about the raccoon.
     *
     * @return
     */
    public String getInfo() {
        return String.format("Racoon Name: %s, Fur Color: %s, Weight: %dg", name, furColor, weight);
    }   

}
