package com.javarush.task.task27.task2712_RESTARAUNT.statistic.event;

import com.javarush.task.task27.task2712_RESTARAUNT.kitchen.stuff.Cook;
import com.javarush.task.task27.task2712_RESTARAUNT.kitchen.Dish;
import com.javarush.task.task27.task2712_RESTARAUNT.kitchen.Order;

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
