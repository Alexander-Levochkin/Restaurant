package statistic.event;

import java.time.LocalDate;

public abstract class Event {
    private final LocalDate date;
    private final int duration;

    protected Event(int duration) {
        this.duration = duration;
        this.date = LocalDate.now();
    }

    public abstract EventType getType();

    public final LocalDate getDate() {
        return date;
    }

    public int getDuration() {
        return duration;
    }
}
