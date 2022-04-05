import Engine.InternalCombustionEngine;
import Engine.ElectricEngine;
import Engine.Engine;

public class Main {
    public static void main(String[] args) {
        Engine teslaEngine = new ElectricEngine("ModelSEngine",518,525, 350, 1180);
        Car tesla = new Car("Tesla", "Model S", "White",
                2021, teslaEngine, 4, 250);
        tesla.moveForward();
        tesla.brake();
        tesla.fullCar();

        Engine toyotaEngine = new InternalCombustionEngine("CorollaEngine", 122, 6.5, 4, 6050, 1);
        Car toyota = new Car("Toyota", "Corolla", "Gray",
                2020, toyotaEngine, 4, 185);
        toyota.moveForward();
        toyota.turnLeft();
        toyota.turnLeft();
        toyota.brake();
    }
}
