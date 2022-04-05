package Engine;

public class InternalCombustionEngine extends Engine{
    private final int numberOfCylinder;
    private final double rotationalMoment;
    private final double oilRate;

    public InternalCombustionEngine(String modelEngine, int horsePower, double fuelRate, int numberOfCylinder, double rotationalMoment, double oilRate) {
        super(modelEngine, horsePower, fuelRate);
        this.numberOfCylinder = numberOfCylinder;
        this.rotationalMoment = rotationalMoment;
        this.oilRate = oilRate;
    }

    public int getNumberOfCylinder() {
        return numberOfCylinder;
    }

    public double getRotationalMoment() {
        return rotationalMoment;
    }

    public double getOilRate() {
        return oilRate;
    }
}
