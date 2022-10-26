package statistic;

import statistic.event.Event;
import statistic.event.EventType;

import java.util.*;
import java.util.stream.Collectors;

public class StatisticManager {
    private static final StatisticManager instance = new StatisticManager();
    private StatisticManager() {
    }
    public static StatisticManager getInstance() {
        return instance;
    }

    public static class StatisticStorage {
        private static final Map<EventType, List<Event>> statistics = new HashMap<>(fillStatistics());

        private static Map<EventType, List<Event>> fillStatistics() {
            return Arrays.stream(EventType.values()).collect(Collectors.toMap(type -> type, type -> new ArrayList<>(), (a, b) -> b));
        }

        private static void put(Event data) {
            EventType type = data.getType();
            statistics.get(type).add(data);
        }

        public static Map<EventType, List<Event>> getStatistics() {
            return statistics;
        }
    }

    public void registerEvent(Event data) {
        StatisticStorage.put(data);
    }
}
