public class Notifier implements EventHandler {
    @Override
    public void handle(Event event) {
        System.out.println("[NOTIFICATION] User alerted about: " + event.getName());
    }
}