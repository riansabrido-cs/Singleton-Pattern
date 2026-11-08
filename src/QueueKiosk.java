public class QueueKiosk {

    private final QueueManager queue = QueueManager.getInstance();

    public int getQueueNumber() {
        int number = queue.issueQueueNumber();
        System.out.println("[Kiosk] Visitor received queue number " + number);
        return number;
    }
}
