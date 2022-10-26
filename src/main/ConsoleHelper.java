package main;

import ad.Advertisement;
import kitchen.Dish;
import kitchen.Order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    //write
    public static void writeln() {
        System.out.println();
    }

    public static void writeln(String message) {
        System.out.println(message);
    }

    public static void writeln(int message) {
        System.out.println(message);
    }

    public static void writelnln(String message) {
        writeln(message + "\n");
    }

    public static void writelnln(int message) {
        writeln(message);
        writeln();
    }

    public static void writef(String format, Object... args) {
        System.out.printf(format, args);
    }

    //read
    public static String readString() throws IOException {
        return reader.readLine();
    }


    //other
    public static List<Dish> getAllDishesForOrder() throws IOException {
        ConsoleHelper.writeln("Available dishes: " + Dish.allDishesToString());
        ConsoleHelper.writeln("Please choose a dish or type \"FINISH\" to finish the order");
        return scanForDishes();
    }

    private static List<Dish> scanForDishes() throws IOException {
        List<Dish> dishesForOrder = new ArrayList<>();

        String currentDish;
        while (!(currentDish = readString()).equalsIgnoreCase("finish")) {
            try {
                Dish dish = Dish.valueOfIgnoreCase(currentDish);
                dishesForOrder.add(dish);
                writeln(currentDish + " has been successfully added to your order");
            } catch (Exception e) {
                writeln(currentDish + " isn't available now");
            }
        }

        if (dishesForOrder.isEmpty()) {
            writeln("You have to order at least 1 dish!");
            return scanForDishes();
        }

        return dishesForOrder;
    }

    public static void writeStartCookingOrder(Order order) {
        writeln("Start cooking - " + order);
    }

    public static void writeFinishedOrder(Order.FinishedOrder finishedOrder) {
        writeln("ORDER IS READY: " + finishedOrder.order() + " was cooked by " + finishedOrder.cook());
    }

    public static void writeNoAvailableVideo() {
        writeln("Unfortunately, no adds are available now");
    }

    public static void writeNoActiveVideos() {
        writelnln("Where are no active videos");
    }

    public static void writeNoArchivedVideos() {
        writelnln("Where are no archived videos");
    }

    public static void displayAdvertisement(Advertisement advertisement) {
        writeln(advertisement.toString() + " is displaying... " + advertisement.getAmountPerOneDisplaying() +
                ", " + (1000 * advertisement.getAmountPerOneDisplaying() / advertisement.getDuration()));
    }
}
