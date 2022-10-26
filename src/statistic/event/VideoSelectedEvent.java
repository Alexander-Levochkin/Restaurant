package com.javarush.task.task27.task2712_RESTARAUNT.statistic.event;

import com.javarush.task.task27.task2712_RESTARAUNT.ad.Advertisement;

import java.util.List;

public class VideoSelectedEvent extends Event {
    private final List<Advertisement> optimalVideoSet;
    private final long amount;

    public VideoSelectedEvent(List<Advertisement> optimalVideoSet, long amount, int duration) {
        super(duration);
        this.optimalVideoSet = optimalVideoSet;
        this.amount = amount;
    }

    @Override
    public EventType getType() {
        return EventType.SELECTED_VIDEOS;
    }

    public long getAmount() {
        return amount;
    }
}
