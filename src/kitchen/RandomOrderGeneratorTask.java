package kitchen;

import java.util.List;

public class RandomOrderGeneratorTask implements Runnable {
    private final List<Tablet> tablets;
    private final int INTERVAL;

    public RandomOrderGeneratorTask(List<Tablet> tablets, int INTERVAL) {
        this.tablets = tablets;
        this.INTERVAL = INTERVAL;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            int tabletId = (int) (Math.random() * tablets.size());
            Tablet tablet = tablets.get(tabletId);
            tablet.createTestOrder();
            try {
                Thread.sleep(INTERVAL);
            } catch (InterruptedException ignored) {
                break;
            }
        }
    }
}
