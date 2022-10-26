package com.javarush.task.task27.task2712_RESTARAUNT.statistic.printer;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

public interface Printer {
    void print();

    default DateTimeFormatter getDateTimeFormatter() {
        return DateTimeFormatter.ofPattern("dd-MMM-yyyy", Locale.ENGLISH);
    }
}
