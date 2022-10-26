package com.javarush.task.task27.task2712_RESTARAUNT.statistic.statisticTypes;

import com.javarush.task.task27.task2712_RESTARAUNT.statistic.StatisticManager;
import com.javarush.task.task27.task2712_RESTARAUNT.statistic.event.EventType;

public class AmountOfNonAdsAvailableErrors {
    public static int getAmountOfNonAdsAvailableErrors() {
        return StatisticManager.StatisticStorage.getStatistics().get(EventType.NO_AVAILABLE_VIDEO).size();
    }
}
