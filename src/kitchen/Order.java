package kitchen;

import main.ConsoleHelper;
import kitchen.stuff.Cook;

import java.io.IOException;
import java.util.List;

public class Order {

    public record FinishedOrder(Cook cook, Order order) {
    }

    private final Tablet tablet;
    protected List<Dish> dishes;
    private final int cookingTime;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        initDishes();
        this.cookingTime = dishes.stream().mapToInt(Dish::getDuration).sum();
    }

    protected void initDishes() throws IOException {
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    @Override
    public String toString() {
        return String.format("Your order: %s of %s, cooking time %dmin",
                dishes.toString(),
                tablet.toString(),
                getCookingTime());
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public Tablet getTablet() {
        return tablet;
    }
}
