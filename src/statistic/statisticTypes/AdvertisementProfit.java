package com.javarush.task.task27.task2712_RESTARAUNT.statistic.statisticTypes;

import com.javarush.task.task27.task2712_RESTARAUNT.statistic.StatisticManager;
import com.javarush.task.task27.task2712_RESTARAUNT.statistic.event.Event;
import com.javarush.task.task27.task2712_RESTARAUNT.statistic.event.EventType;
import com.javarush.task.task27.task2712_RESTARAUNT.statistic.event.VideoSelectedEvent;

import java.time.LocalDate;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class AdvertisementProfit {
    private static long totalProfit;

    public static long getTotalProfit() {
        return totalProfit;
    }

    public static Map<LocalDate, Long> getAdvertisementProfit() {
        totalProfit = 0;

        Map<LocalDate, Long> advertisementProfit = new TreeMap<>();

        for (Event event : StatisticManager.StatisticStorage.getStatistics().get(EventType.SELECTED_VIDEOS)) {
            long amount = ((VideoSelectedEvent) event).getAmount();
            advertisementProfit.merge(event.getDate(), amount, Long::sum);
            totalProfit += amount;
        }

        return advertisementProfit;
    }
}
