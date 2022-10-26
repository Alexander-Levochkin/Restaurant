package com.javarush.task.task27.task2712_RESTARAUNT.statistic.printer;

import com.javarush.task.task27.task2712_RESTARAUNT.ConsoleHelper;
import com.javarush.task.task27.task2712_RESTARAUNT.statistic.statisticTypes.AmountOfNonAdsAvailableErrors;

public class AmountOfNonAdsAvailableErrorsPrinter implements Printer {
    @Override
    public void print() {
        ConsoleHelper.writelnln(AmountOfNonAdsAvailableErrors.getAmountOfNonAdsAvailableErrors());
    }
}
