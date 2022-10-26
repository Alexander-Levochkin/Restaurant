package com.javarush.task.task27.task2712_RESTARAUNT.kitchen.stuff;

public abstract class Stuff implements Runnable {
    private final String name;

    public Stuff(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
