//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
// VehicleController skapas för att kunna använda objecten Car och Bicycle.
        VehicleController controller = new VehicleController();

        Vehicle car = new Car();
        Vehicle bicycle = new Bicycle();

        controller.makeVehicleMove(bicycle);
        controller.makeVehicleMove(car);

    }

    public void makeVehicleMove(Vehicle vehicle) {
        vehicle.move();
    }
}
