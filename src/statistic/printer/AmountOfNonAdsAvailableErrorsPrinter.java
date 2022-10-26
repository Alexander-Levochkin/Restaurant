package statistic.printer;

import main.ConsoleHelper;
import statistic.statisticTypes.AmountOfNonAdsAvailableErrors;

public class AmountOfNonAdsAvailableErrorsPrinter implements Printer {
    @Override
    public void print() {
        ConsoleHelper.writelnln(AmountOfNonAdsAvailableErrors.getAmountOfNonAdsAvailableErrors());
    }
}
