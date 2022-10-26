package statistic.printer;

import main.ConsoleHelper;
import ad.Advertisement;
import statistic.statisticTypes.Advertisements;

import java.util.List;

public class ActiveAdvertisementsPrinter implements Printer {
    @Override
    public void print() {
        List<Advertisement> activeAdvertisements = Advertisements.getAdvertisements(true);

        if (activeAdvertisements.size() == 0) {
            ConsoleHelper.writeNoActiveVideos();
            return;
        }

        for (Advertisement advertisement : activeAdvertisements) {
            ConsoleHelper.writeln(advertisement.toString() + " - " + advertisement.getHits());
        }
        ConsoleHelper.writeln();
    }
}
