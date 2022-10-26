package statistic;

import statistic.printer.*;

import java.util.List;

public class DirectorTablet {
    private static final DirectorTablet instance = new DirectorTablet();

    public static DirectorTablet getInstance() {
        return instance;
    }

    private DirectorTablet() {
        infoPrinters = List.of(new ActiveAdvertisementsPrinter(), new AdvertisementProfitPrinter(),
                new AmountOfNonAdsAvailableErrorsPrinter(), new ArchivedAdvertisementsPrinter(),
                new CookWorkloadPrinter());
    }

    private final List<Printer> infoPrinters;

    public void printStatistics() {
        infoPrinters.forEach(Printer::print);
    }

    public void printAdvertisementProfit() {
        new AdvertisementProfitPrinter().print();
    }

    public void printCookWorkload() {
        new CookWorkloadPrinter().print();
    }

    public void printActiveAdvertisements() {
        new ActiveAdvertisementsPrinter().print();
    }

    public void printArchivedAdvertisements() {
        new ArchivedAdvertisementsPrinter().print();
    }
}
