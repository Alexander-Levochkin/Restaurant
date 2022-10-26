package kitchen.stuff;

import main.ConsoleHelper;
import kitchen.Order;
import statistic.StatisticManager;
import statistic.event.CookedOrderEvent;

import static main.Restaurant.FINISHED_ORDER_QUEUE;
import static main.Restaurant.ORDER_QUEUE;

public class Cook extends Stuff {
    public Cook(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                if (!ORDER_QUEUE.isEmpty())
                    startCookingOrder(ORDER_QUEUE.take());
                else Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void startCookingOrder(Order order) {
        ConsoleHelper.writeStartCookingOrder(order);

        try {
            Thread.sleep(order.getCookingTime() * 10L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        FINISHED_ORDER_QUEUE.add(new Order.FinishedOrder(this, order));

        StatisticManager.getInstance().registerEvent(new CookedOrderEvent(order, this));
    }
}
