package statistic.statisticTypes;

import statistic.StatisticManager;
import statistic.event.EventType;

public class AmountOfNonAdsAvailableErrors {
    public static int getAmountOfNonAdsAvailableErrors() {
        return StatisticManager.StatisticStorage.getStatistics().get(EventType.NO_AVAILABLE_VIDEO).size();
    }
}
