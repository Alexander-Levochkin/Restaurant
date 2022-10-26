package kitchen;

import java.util.Arrays;

public enum Dish {
    FISH(25),
    STEAK(30),
    SOUP(15),
    JUICE(5),
    WATER(3);

    private final int duration;

    Dish(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public static String allDishesToString() {
        return Arrays.toString(Dish.values()).replaceAll("[\\[\\]]", "");
    }

    public static Dish valueOfIgnoreCase(String name) {
        return Dish.valueOf(name.toUpperCase());
    }
}
