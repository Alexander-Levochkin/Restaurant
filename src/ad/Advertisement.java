package com.javarush.task.task27.task2712_RESTARAUNT.ad;

public class Advertisement {
    private final Object content;
    private final String name;
    private long initialAmount;
    private int hits;
    private long amountPerOneDisplaying;
    private final int duration;

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;

        if (hits > 0) amountPerOneDisplaying = initialAmount / hits;
    }

    public void revalidate() {
        if (hits <= 0) throw new UnsupportedOperationException();
        hits--;
    }

    public boolean isActive() {
        return hits > 0;
    }

    public int getHits() {
        return hits;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return name;
    }
}
