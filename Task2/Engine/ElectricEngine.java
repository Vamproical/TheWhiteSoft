package Engine;

public class ElectricEngine extends Engine{

    private final double ratedVoltage;
    private final double speedRotation;

    public ElectricEngine(String modelEngine, int horsePower, double fuelRate, double ratedVoltage, double speedRotation) {
        super(modelEngine, horsePower, fuelRate);
        this.ratedVoltage = ratedVoltage;
        this.speedRotation = speedRotation;
    }

    public double getSpeedRotation() {
        return speedRotation;
    }

    public double getRatedVoltage() {
        return ratedVoltage;
    }

}
