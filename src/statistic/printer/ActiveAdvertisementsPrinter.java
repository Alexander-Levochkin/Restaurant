package com.javarush.task.task27.task2712_RESTARAUNT.statistic.printer;

import com.javarush.task.task27.task2712_RESTARAUNT.ConsoleHelper;
import com.javarush.task.task27.task2712_RESTARAUNT.ad.Advertisement;
import com.javarush.task.task27.task2712_RESTARAUNT.statistic.statisticTypes.Advertisements;

import java.util.List;

public class ActiveAdvertisementsPrinter implements Printer {
    @Override
    public void print() {
        List<Advertisement> activeAdvertisements = Advertisements.getAdvertisements(true);

        if (activeAdvertisements.size() == 0) {
            ConsoleHelper.writeNoActiveVideos();
            return;
        }

        for (Advertisement advertisement : activeAdvertisements) {
            ConsoleHelper.writeln(advertisement.toString() + " - " + advertisement.getHits());
        }
        ConsoleHelper.writeln();
    }
}
