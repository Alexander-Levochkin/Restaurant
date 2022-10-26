package com.javarush.task.task27.task2712_RESTARAUNT.kitchen.stuff;

import com.javarush.task.task27.task2712_RESTARAUNT.ConsoleHelper;
import com.javarush.task.task27.task2712_RESTARAUNT.kitchen.Order;

import static com.javarush.task.task27.task2712_RESTARAUNT.Restaurant.FINISHED_ORDER_QUEUE;

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
