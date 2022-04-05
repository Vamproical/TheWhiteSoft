import Engine.Engine;

public class Car implements Drivable{
    private final String make;
    private final String modelCar;
    private final String colorCar;
    private final int yearOfRelease;
    private final Engine engine;
    private final int numberOfDoor;
    private final double maxSpeed;

    public Car(String make, String modelCar, String colorCar, int yearOfRelease, Engine engine, int numberOfDoor, double maxSpeed) {
        this.make = make;
        this.modelCar = modelCar;
        this.colorCar = colorCar;
        this.yearOfRelease = yearOfRelease;
        this.engine = engine;
        this.numberOfDoor = numberOfDoor;
        this.maxSpeed = maxSpeed;
    }

    public void fullCar() {
        System.out.println("The car is refueled");
    }

    public String getMake() {
        return make;
    }

    public String getColorCar() {
        return colorCar;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public int getNumberOfDoor() {
        return numberOfDoor;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public void moveForward() {
        System.out.println("The car " + modelCar + " is moving forward");
    }

    @Override
    public void moveBackward() {
        System.out.println("The car " + modelCar + " is moving backward");
    }

    @Override
    public void turnLeft() {
        System.out.println("The car " + modelCar + " is turning left");
    }

    @Override
    public void turnRight() {
        System.out.println("The car " + modelCar + " is turning right");
    }

    @Override
    public void brake() {
        System.out.println("The car " + modelCar + " is slowing down");
    }
}
