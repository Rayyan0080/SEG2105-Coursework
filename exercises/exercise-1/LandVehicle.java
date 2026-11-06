import java.time.Instant;

public abstract class LandVehicle extends Vehicle {
    @Override public abstract double getMaxWeight();
    @Override public abstract double getMaxSpeed();
    @Override public abstract double getMinSpeed();
    @Override public abstract Instant getRegistrationTime();
    @Override public abstract String getVehicleType();
}