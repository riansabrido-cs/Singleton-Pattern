public class HelpDeskStation {

    private final int stationId;
    private final QueueManager queue = QueueManager.getInstance();

    public HelpDeskStation(int stationId) {
        this.stationId = stationId;
    }

    public int getStationId() {
        return stationId;
    }

    public void callNext() {
        int number = queue.callNext(stationId);
        if (number == -1) {
            System.out.println("[Station " + stationId + "] No one is waiting.");
        } else {
            System.out.println("[Station " + stationId + "] Now serving number " + number);
        }
    }

    public void resetQueue(int newNumber) {
        queue.resetQueue(stationId, newNumber);
    }
}
