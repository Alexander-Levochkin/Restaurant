package com.javarush.task.task27.task2712_RESTARAUNT.statistic.printer;

import com.javarush.task.task27.task2712_RESTARAUNT.ConsoleHelper;
import com.javarush.task.task27.task2712_RESTARAUNT.statistic.statisticTypes.CookWorkLoading;

public class CookWorkloadPrinter implements Printer {
    @Override
    public void print() {
        for (var entry : CookWorkLoading.getCookWorkLoading().entrySet()) {
            String date = getDateTimeFormatter().format(entry.getKey());
            ConsoleHelper.writeln(date);
            entry.getValue().forEach((cookName, cookingTime) -> ConsoleHelper.writeln(cookName + " - " + ((cookingTime + 59) / 60) + " min"));
        }
        ConsoleHelper.writeln();
    }
}
