package statistic.printer;

import main.ConsoleHelper;
import statistic.statisticTypes.AdvertisementProfit;

import java.util.Locale;

public class AdvertisementProfitPrinter implements Printer {
    @Override
    public void print() {
        for (var entry : AdvertisementProfit.getAdvertisementProfit().entrySet()) {
            String date = getDateTimeFormatter().format(entry.getKey());

            double amount = 1.0 * entry.getValue() / 100;
            ConsoleHelper.writeln(date + " - " + String.format(Locale.ENGLISH, "%.2f", amount));
        }

        double totalProfit = 1.0 * AdvertisementProfit.getTotalProfit() / 100;
        ConsoleHelper.writelnln(String.format("Total - %.2f", totalProfit));
    }
}
