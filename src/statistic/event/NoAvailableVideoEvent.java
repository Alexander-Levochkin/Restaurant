package statistic.event;

import kitchen.Order;

public class NoAvailableVideoEvent extends Event {
    public NoAvailableVideoEvent(Order order) {
        super(order.getCookingTime());
    }

    @Override
    public EventType getType() {
        return EventType.NO_AVAILABLE_VIDEO;
    }
}
