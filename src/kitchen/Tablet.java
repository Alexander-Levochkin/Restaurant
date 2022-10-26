package other;

import ad.AdvertisementIndicator;
import ad.NoVideoAvailableException;
import kitchen.Order;
import kitchen.TestOrder;
import statistic.StatisticManager;
import statistic.event.NoAvailableVideoEvent;

import java.io.IOException;
import java.util.Objects;

public class Tablet {
    private final int number;

    public Tablet(int number) {
        this.number = number;
    }

    public Order createOrder() {
        Order order = null;
        try {
            order = new Order(this);
            processOrder(order);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        } catch (NoVideoAvailableException e) {
            handleNoAvailableVideoException(Objects.requireNonNull(order));
        }

        return order;
    }

    public Order createTestOrder() {
        Order order = null;

        try {
            order = new TestOrder(this);
            processOrder(order);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        } catch (NoVideoAvailableException ignored) {
            handleNoAvailableVideoException(Objects.requireNonNull(order));
        }

        return order;
    }

    private void handleNoAvailableVideoException(Order order) {
        StatisticManager.getInstance().registerEvent(new NoAvailableVideoEvent(order));
        ConsoleHelper.writeNoAvailableVideo();
    }

    private void processOrder(Order order) throws NoVideoAvailableException, InterruptedException {
        Restaurant.ORDER_QUEUE.add(order);
        Thread.sleep(100);
        new Thread(new AdvertisementIndicator(order.getCookingTime() * 60)).start();
    }

    @Override
    public String toString() {
        return String.format("%s{number=%d}", this.getClass().getSimpleName(), number);
    }
}
