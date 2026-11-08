# Singleton-Pattern


## Problem Statement

The Pag-ibig office implements a centralized queuing system for three help desk stations. Individuals visiting the office obtain a queue number from this centralized system. Additionally, there's an online monitoring system that displays the current queued number in real-time for individuals monitoring the queue remotely.

Each help desk station has an option to reset the queuing number based on an inputted number, allowing flexibility in managing the queue during specific situations, such as reorganization or technical issues. This queuing system ensures a single centralized queue number for all help desk stations, while the reset option offers control and adjustment in exceptional circumstances.

This approach aims to maintain an organized queuing process for individuals visiting the office and provides the flexibility to handle queue adjustments as needed.

## UML Class Diagram

```mermaid
classDiagram
    class QueueManager {
        -QueueManager instance$
        -int lastIssuedNumber
        -int currentServingNumber
        -QueueManager()
        +getInstance()$ QueueManager
        +issueQueueNumber() int
        +callNext(int stationId) int
        +resetQueue(int stationId, int newNumber) void
        +getCurrentServingNumber() int
        +getLastIssuedNumber() int
        +getWaitingCount() int
    }
    class HelpDeskStation {
        -int stationId
        +callNext() void
        +resetQueue(int newNumber) void
    }
    class QueueKiosk {
        +getQueueNumber() int
    }
    class OnlineMonitor {
        +display() void
    }
    class Main {
        +main(String[] args)$ void
    }

    HelpDeskStation ..> QueueManager : uses getInstance()
    QueueKiosk ..> QueueManager : uses getInstance()
    OnlineMonitor ..> QueueManager : uses getInstance()
    Main ..> HelpDeskStation
    Main ..> QueueKiosk
    Main ..> OnlineMonitor
    QueueManager --> QueueManager : single instance
```


