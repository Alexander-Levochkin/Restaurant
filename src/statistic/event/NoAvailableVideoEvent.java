package com.javarush.task.task27.task2712_RESTARAUNT.statistic.event;

import com.javarush.task.task27.task2712_RESTARAUNT.kitchen.Order;

public class NoAvailableVideoEvent extends Event {
    public NoAvailableVideoEvent(Order order) {
        super(order.getCookingTime());
    }

    @Override
    public EventType getType() {
        return EventType.NO_AVAILABLE_VIDEO;
    }
}
