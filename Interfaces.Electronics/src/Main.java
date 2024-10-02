import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<ElectronicDevice> deviceList = new ArrayList<>();
        ElectronicDevice tv = new TV();
        ElectronicDevice radio = new Radio();

        deviceList.add(tv);
        deviceList.add(radio);

        for (ElectronicDevice device : deviceList){
            System.out.println(device.turnOff() + " and " + device.turnOn());
        }

    }
}