public class Main {
    public static void main(String[] args) {
        QueueManager a = QueueManager.getInstance();
        QueueManager b = QueueManager.getInstance();
        System.out.println("Same instance? " + (a == b));
        System.out.println();

        QueueKiosk kiosk = new QueueKiosk();
        OnlineMonitor monitor = new OnlineMonitor();
        HelpDeskStation station1 = new HelpDeskStation(1);
        HelpDeskStation station2 = new HelpDeskStation(2);
        HelpDeskStation station3 = new HelpDeskStation(3);

        for (int i = 0; i < 5; i++) {
            kiosk.getQueueNumber();
        }
        monitor.display();
        System.out.println();

        station1.callNext();
        station2.callNext();
        station3.callNext();
        monitor.display();
        System.out.println();

        station2.resetQueue(100);
        monitor.display();
        System.out.println();

        kiosk.getQueueNumber();
        kiosk.getQueueNumber();
        station1.callNext();
        monitor.display();
        station3.callNext();
        station3.callNext();
        monitor.display();
    }
}
