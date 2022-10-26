package ad;

import main.ConsoleHelper;
import statistic.StatisticManager;
import statistic.event.VideoSelectedEvent;

import java.util.ArrayList;
import java.util.List;

public class AdvertisementIndicator implements Runnable {

    private final int orderPreparationTime;

    public AdvertisementIndicator(int orderPreparationTime) {
        this.orderPreparationTime = orderPreparationTime;
    }

    @Override
    public void run() throws NoVideoAvailableException {
        validateAdvertisements();

        this.totalTimeSecondsLeft = Integer.MAX_VALUE;
        obtainOptimalVideoSet(new ArrayList<>(), orderPreparationTime, 0L);

        displayAdvertisement();

        StatisticManager.getInstance().registerEvent(new VideoSelectedEvent(optimalAdvertisementSet, maxAmount, orderPreparationTime - totalTimeSecondsLeft));
    }

    public static class AdvertisementStorage {
        private static final List<Advertisement> advertisements = new ArrayList<>(fillAdvertisements());

        private static List<Advertisement> fillAdvertisements() {
            List<Advertisement> result = new ArrayList<>();

            Object video = new Object();
            result.add(new Advertisement(video, "First Video", 5000, 1, 15 * 60));
            result.add(new Advertisement(video, "Third Video", 4000, 2, 10 * 60));
            result.add(new Advertisement(video, "Second Video", 300, 5, 3 * 60));

            return result;
        }

        public static List<Advertisement> getAdvertisements() {
            return advertisements;
        }

        public static List<Advertisement> getActualAdvertisements() {
            return advertisements.stream().filter(Advertisement::isActive).toList();
        }
    }

    private void validateAdvertisements() throws NoVideoAvailableException {
        if (AdvertisementStorage.getActualAdvertisements().isEmpty()) throw new NoVideoAvailableException();
    }

    //recursion
    private long maxAmount;
    private List<Advertisement> optimalAdvertisementSet;
    private int totalTimeSecondsLeft;

    private void obtainOptimalVideoSet(List<Advertisement> totalList, int currentTimeSecondsLeft, long currentAmount) {
        if (currentTimeSecondsLeft < 0) {
            return;
        } else if (currentAmount > maxAmount
                || currentAmount == maxAmount && (totalTimeSecondsLeft > currentTimeSecondsLeft
                || totalTimeSecondsLeft == currentTimeSecondsLeft && totalList.size() < optimalAdvertisementSet.size())) {
            this.totalTimeSecondsLeft = currentTimeSecondsLeft;
            this.optimalAdvertisementSet = totalList;
            this.maxAmount = currentAmount;
            if (currentTimeSecondsLeft == 0) {
                return;
            }
        }

        List<Advertisement> tmp = AdvertisementStorage.getActualAdvertisements();
        tmp.removeAll(totalList);
        for (Advertisement ad : tmp) {
            List<Advertisement> currentList = new ArrayList<>(totalList);
            currentList.add(ad);
            obtainOptimalVideoSet(currentList, currentTimeSecondsLeft - ad.getDuration(), currentAmount + ad.getAmountPerOneDisplaying());
        }
    }

    private void displayAdvertisement() {
        optimalAdvertisementSet.sort((o1, o2) -> {
            long l = o2.getAmountPerOneDisplaying() - o1.getAmountPerOneDisplaying();
            return (int) (l != 0 ? l : o2.getDuration() - o1.getDuration());
        });

        for (Advertisement advertisement : optimalAdvertisementSet) {
            displayInPlayer(advertisement);
            advertisement.revalidate();
        }
    }

    private void displayInPlayer(Advertisement advertisement) {
        ConsoleHelper.displayAdvertisement(advertisement);

        try {
            Thread.sleep(advertisement.getDuration());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
