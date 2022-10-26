package statistic.printer;

import main.ConsoleHelper;
import ad.Advertisement;
import statistic.statisticTypes.Advertisements;

import java.util.List;

public class ArchivedAdvertisementsPrinter implements Printer {
    @Override
    public void print() {
        List<Advertisement> archivedAdvertisements = Advertisements.getAdvertisements(false);

        if (archivedAdvertisements.size() == 0)
            ConsoleHelper.writeNoArchivedVideos();
        else {
            for (Advertisement advertisement : archivedAdvertisements) {
                ConsoleHelper.writeln(advertisement.toString());
            }
            ConsoleHelper.writeln();
        }
    }
}
