import java.time.Instant;
import java.util.concurrent.atomic.AtomicLong;

public abstract class Vehicle implements Printable {
    // IDs start at 0
    private static final AtomicLong SEQ = new AtomicLong(0);
    private final long id = SEQ.getAndIncrement();

    private double emptyWeight;   // kg
    private double cruiseSpeed;   // km/h

    public abstract double getMaxWeight();
    public abstract double getMaxSpeed();
    public abstract double getMinSpeed();
    public abstract Instant getRegistrationTime();
    public abstract String getVehicleType();

    protected Vehicle() {
        setEmptyWeight(0.30 * getMaxWeight());
        setCruiseSpeed(0.30 * getMaxSpeed());
    }

    protected Vehicle(double emptyWeight, double cruiseSpeed) {
        setEmptyWeight(emptyWeight);
        setCruiseSpeed(cruiseSpeed);
    }

    public final long getId() { return id; }

    public final double getEmptyWeight() { return emptyWeight; }
    public final void setEmptyWeight(double emptyWeight) {
        if (emptyWeight <= 0) {
            throw new IllegalArgumentException("emptyWeight must be > 0");
        }
        if (emptyWeight > getMaxWeight()) {
            throw new IllegalArgumentException(
                "emptyWeight must be <= MAX_WEIGHT (" + String.format("%.1f", getMaxWeight()) + ")"
            );
        }
        this.emptyWeight = emptyWeight;
    }

    public final double getCruiseSpeed() { return cruiseSpeed; }
    public final void setCruiseSpeed(double cruiseSpeed) {
        if (cruiseSpeed > getMaxSpeed()) {
            throw new IllegalArgumentException(
                "cruiseSpeed must be <= MAX_SPEED (" + String.format("%.1f", getMaxSpeed()) + ")"
            );
        }
        if (cruiseSpeed < getMinSpeed()) {
            throw new IllegalArgumentException(
                "cruiseSpeed must be >= MIN_SPEED (" + String.format("%.1f", getMinSpeed()) + ")"
            );
        }
        this.cruiseSpeed = cruiseSpeed;
    }

    // lifecycle messages (exact wording)
    public void start() { System.out.println(getVehicleType() + " [" + id + "] starting"); }
    public void move()  { System.out.println(getVehicleType() + " [" + id + "] moving at " +
                           String.format("%.2f", cruiseSpeed) + " km/h"); }
    public void stop()  { System.out.println(getVehicleType() + " [" + id + "] stopped"); }

    public final void operate() { start(); move(); stop(); }

    @Override
    public void dump() {
        System.out.println("--- " + getVehicleType() + " ---");
        printKV("id", String.valueOf(id));
        printKV("emptyWeight", String.format("%.2f kg", getEmptyWeight()));
        printKV("cruiseSpeed", String.format("%.2f km/h", getCruiseSpeed()));
        printKV("MAX_WEIGHT", String.format("%.2f kg", getMaxWeight()));
        printKV("MAX_SPEED", String.format("%.2f km/h", getMaxSpeed()));
        printKV("MIN_SPEED", String.format("%.2f km/h", getMinSpeed()));
        printKV("REG_TIME", getRegistrationTime().toString());
        // removed trailing blank line to match exact expected output
    }

    private static void printKV(String key, String value) {
        System.out.printf("%-14s: %s%n", key, value);
    }
}