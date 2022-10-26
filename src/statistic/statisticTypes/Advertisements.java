package statistic.statisticTypes;

import ad.Advertisement;
import ad.AdvertisementIndicator;

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
