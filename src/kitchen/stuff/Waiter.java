package kitchen.stuff;

import main.ConsoleHelper;
import kitchen.Order;

import static main.Restaurant.FINISHED_ORDER_QUEUE;

public class Waiter extends Stuff implements Runnable {
    public Waiter(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                synchronized (FINISHED_ORDER_QUEUE) {
                    if (!FINISHED_ORDER_QUEUE.isEmpty())
                        bringOrder(FINISHED_ORDER_QUEUE.take());
                    else Thread.sleep(500);
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void bringOrder(Order.FinishedOrder finishedOrder) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {
            throw new RuntimeException(this + "Failed to bring the order");
        }

        ConsoleHelper.writeFinishedOrder(finishedOrder);
    }
}
