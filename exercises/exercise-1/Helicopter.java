import java.time.Instant;

public class Helicopter extends AirVehicle {
    public static final double MAX_WEIGHT = 5000.0;
    public static final double MAX_SPEED  = 250.0;
    public static final double MIN_SPEED  = MAX_SPEED * 0.10;

    public final Instant registrationTime = Instant.now();

    private static int counter = 0;

    public Helicopter() { super(); counter++; }
    public Helicopter(double emptyWeight, double cruiseSpeed) {
        super(emptyWeight, cruiseSpeed); counter++;
    }

    public static int count() { return counter; }

    @Override public double getMaxWeight() { return MAX_WEIGHT; }
    @Override public double getMaxSpeed()  { return MAX_SPEED; }
    @Override public double getMinSpeed()  { return MIN_SPEED; }
    @Override public Instant getRegistrationTime() { return registrationTime; }
    @Override public String getVehicleType() { return "Helicopter"; }
}