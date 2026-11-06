   public class Event {
   private final String name;
    private final int priority;

    public Event(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Event{name='" + name + "', priority=" + priority + "}";
    }
}