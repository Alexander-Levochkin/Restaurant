package com.javarush.task.task27.task2712_RESTARAUNT.statistic.statisticTypes;

import com.javarush.task.task27.task2712_RESTARAUNT.ad.Advertisement;
import com.javarush.task.task27.task2712_RESTARAUNT.ad.AdvertisementIndicator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Advertisements {
    public static List<Advertisement> getAdvertisements(boolean isActive) {
        Set<Advertisement> result = new TreeSet<>((o1, o2) -> o1.toString().compareToIgnoreCase(o2.toString()));

        for (Advertisement advertisement : AdvertisementIndicator.AdvertisementStorage.getAdvertisements())
            if (!isActive ^ advertisement.isActive())
                result.add(advertisement);

        return new ArrayList<>(result);
    }
}
