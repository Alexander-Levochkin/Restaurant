package com.javarush.task.task27.task2712_RESTARAUNT.statistic.printer;

import com.javarush.task.task27.task2712_RESTARAUNT.ConsoleHelper;
import com.javarush.task.task27.task2712_RESTARAUNT.ad.Advertisement;
import com.javarush.task.task27.task2712_RESTARAUNT.statistic.statisticTypes.Advertisements;

import java.util.List;

public class ArchivedAdvertisementsPrinter implements Printer {
    @Override
    public void print() {
        List<Advertisement> archivedAdvertisements = Advertisements.getAdvertisements(false);

        if (archivedAdvertisements.size() == 0)
            ConsoleHelper.writeNoArchivedVideos();
        else {
            for (Advertisement advertisement : archivedAdvertisements) {
                ConsoleHelper.writeln(advertisement.toString());
            }
            ConsoleHelper.writeln();
        }
    }
}
