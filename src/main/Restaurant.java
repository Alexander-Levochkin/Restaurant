package main;

import kitchen.Order;
import kitchen.stuff.Cook;
import kitchen.stuff.Waiter;
import kitchen.RandomOrderGeneratorTask;
import kitchen.Tablet;
import statistic.DirectorTablet;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant extends Thread {
    private static final int ORDER_CREATING_INTERVAL = 1000;
    public static final LinkedBlockingQueue<Order> ORDER_QUEUE = new LinkedBlockingQueue<>();
    public static final LinkedBlockingQueue<Order.FinishedOrder> FINISHED_ORDER_QUEUE = new LinkedBlockingQueue<>();

    @Override
    public void run() {
        createStuff();

        generateOrders();

//        generateFakeOrders();

        while (!ORDER_QUEUE.isEmpty() || !FINISHED_ORDER_QUEUE.isEmpty()) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        printStatistics();
    }

    private void createStuff() {
        Thread cook = new Thread(new Cook("Your dad"));
        cook.setDaemon(true);
        cook.start();

        Thread waiter = new Thread(new Waiter("Your mom"));
        waiter.setDaemon(true);
        waiter.start();
    }

    private void generateOrders() {
        Tablet tablet = new Tablet(1);
        tablet.createOrder();
    }

    private void generateFakeOrders() {
        List<Tablet> tablets = new ArrayList<>();
        for (int i = 0; i < 5; i++) tablets.add(new Tablet(i));

        Thread generatorTaskThread = new Thread(new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL));
        generatorTaskThread.start();
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        generatorTaskThread.interrupt();
    }

    private void printStatistics() {
        ConsoleHelper.writeln();
        ConsoleHelper.writeln("STATISTICS:");

        DirectorTablet directorTablet = DirectorTablet.getInstance();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkload();
        directorTablet.printActiveAdvertisements();
        directorTablet.printArchivedAdvertisements();
    }
}
