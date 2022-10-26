package statistic.event;

import kitchen.Dish;
import kitchen.Order;
import kitchen.stuff.Cook;

import java.util.List;

public class CookedOrderEvent extends Event {
    private final String tabletName;
    private final String cookName;
    private final List<Dish> dishes;

    public CookedOrderEvent(Order order, Cook cook) {
        super(order.getCookingTime() * 60);
        this.tabletName = order.getTablet().toString();
        this.cookName = cook.toString();
        this.dishes = order.getDishes();
    }

    @Override
    public EventType getType() {
        return EventType.COOKED_ORDER;
    }

    public String getCookName() {
        return cookName;
    }
}
