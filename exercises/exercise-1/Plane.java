import java.time.Instant;

public class Plane extends AirVehicle {
    public static final double MAX_WEIGHT = 80000.0;
    public static final double MAX_SPEED  = 900.0;
    public static final double MIN_SPEED  = MAX_SPEED * 0.10;

    public final Instant registrationTime = Instant.now();

    private static int counter = 0;

    public Plane() { super(); counter++; }
    public Plane(double emptyWeight, double cruiseSpeed) {
        super(emptyWeight, cruiseSpeed); counter++;
    }

    public static int count() { return counter; }

    @Override public double getMaxWeight() { return MAX_WEIGHT; }
    @Override public double getMaxSpeed()  { return MAX_SPEED; }
    @Override public double getMinSpeed()  { return MIN_SPEED; }
    @Override public Instant getRegistrationTime() { return registrationTime; }
    @Override public String getVehicleType() { return "Plane"; }
}