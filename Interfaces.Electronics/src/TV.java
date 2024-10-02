public class TV implements ElectronicDevice {
    @Override
    public String turnOff() {
       return "TV turns OFF";
    }

    @Override
    public String turnOn() {
        return "TV turns ON";

    }
}
