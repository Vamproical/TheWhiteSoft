package Engine;

public abstract class Engine {
    private final String modelEngine;
    private final int horsePower;
    private final double fuelRate;

    protected Engine(String modelEngine, int horsePower, double fuelRate) {
        this.modelEngine = modelEngine;
        this.horsePower = horsePower;
        this.fuelRate = fuelRate;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public double getFuelRate() {
        return fuelRate;
    }

}
