package statistic.statisticTypes;

import statistic.StatisticManager;
import statistic.event.CookedOrderEvent;
import statistic.event.Event;
import statistic.event.EventType;

import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

public class CookWorkLoading {
    public static Map<LocalDate, TreeMap<String, Integer>> getCookWorkLoading() {
        Map<LocalDate, TreeMap<String, Integer>> result = new TreeMap<>();

        for (Event event : StatisticManager.StatisticStorage.getStatistics().get(EventType.COOKED_ORDER)) {
            CookedOrderEvent tempEvent = (CookedOrderEvent) event;
            String cookName = tempEvent.getCookName();
            int cookingTimeSeconds = tempEvent.getDuration();

            TreeMap<String, Integer> tempMap = new TreeMap<>();
            tempMap.put(cookName, cookingTimeSeconds);

            result.merge(event.getDate(), tempMap, (stringIntegerMap, stringIntegerMap2) -> {
                stringIntegerMap.merge(cookName, cookingTimeSeconds, Integer::sum);
                return stringIntegerMap;
            });
        }

        return result;
    }
}
