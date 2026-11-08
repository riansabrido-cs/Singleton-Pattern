public class OnlineMonitor {

    private final QueueManager queue = QueueManager.getInstance();

    public void display() {
        System.out.println("[Online Monitor] Now serving: " + queue.getCurrentServingNumber()
                + " | Last issued: " + queue.getLastIssuedNumber()
                + " | Waiting: " + queue.getWaitingCount());
    }
}
