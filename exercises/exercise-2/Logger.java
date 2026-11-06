public class Logger implements EventHandler {
    @Override
    public void handle(Event event) {
        System.out.println("[LOG] " + event);
    }
}