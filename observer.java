import java.util.*;



public class Main {
    public static void main(String[] args) {
        NotificationService service = new NotificationService();

        EventListener user1 = new EmailMsgListener("user1@example.com");
        EventListener user2 = new EmailMsgListener("user2@example.com");

        service.subscribe(Event.NEW_ITEM, user1);
        service.subscribe(Event.SALE, user2);

        System.out.println("Triggering NEW_ITEM event...");
        service.notify(Event.NEW_ITEM);

        System.out.println("Triggering SALE event...");
        service.notify(Event.SALE);
    }
}

interface EventListener {
    void update(Event eventType);
}

class EmailMsgListener implements EventListener {
    private final String email;

    public EmailMsgListener(String email) {
        this.email = email;
    }

    
    public void update(Event eventType) {
        System.out.println("Email sent to " + email + " for event: " + eventType);
    }
}

enum Event {
    NEW_ITEM,
    SALE
}



public class NotificationService {
    private final Map<Event, List<EventListener>> customers;

    public NotificationService() {
        customers = new HashMap<>();
        Arrays.stream(Event.values()).forEach(event -> customers.put(event, new ArrayList<>()));
    }

    public void subscribe(Event eventType, EventListener listener) {
        customers.get(eventType).add(listener);
    }

    public void unsubscribe(Event eventType, EventListener listener) {
        customers.get(eventType).remove(listener);
    }

    public void notify(Event eventType) {
        customers.get(eventType).forEach(listener -> listener.update(eventType));
    }
}

