public final class QueueManager {

    private static volatile QueueManager instance;

    private int lastIssuedNumber = 0;
    private int currentServingNumber = 0;

    private QueueManager() {
    }

    public static QueueManager getInstance() {
        if (instance == null) {
            synchronized (QueueManager.class) {
                if (instance == null) {
                    instance = new QueueManager();
                }
            }
        }
        return instance;
    }

    public synchronized int issueQueueNumber() {
        lastIssuedNumber++;
        return lastIssuedNumber;
    }

    public synchronized int callNext(int stationId) {
        if (currentServingNumber >= lastIssuedNumber) {
            return -1;
        }
        currentServingNumber++;
        return currentServingNumber;
    }

    public synchronized void resetQueue(int stationId, int newNumber) {
        if (newNumber < 1) {
            throw new IllegalArgumentException("Reset number must be 1 or higher.");
        }
        lastIssuedNumber = newNumber - 1;
        currentServingNumber = newNumber - 1;
        System.out.println("[Station " + stationId + "] Queue reset. Next number: " + newNumber);
    }

    public synchronized int getCurrentServingNumber() {
        return currentServingNumber;
    }

    public synchronized int getLastIssuedNumber() {
        return lastIssuedNumber;
    }

    public synchronized int getWaitingCount() {
        return lastIssuedNumber - currentServingNumber;
    }
}
