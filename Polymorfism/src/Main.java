import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Animal> animals = new ArrayList<>();

        Hyena hyena = new Hyena("Hattie");
        Hyena hyena1 = new Hyena("James");

        Lion lion = new Lion("Janet");
        Lion lion1 = new Lion("Harold");

        animals.add(hyena);
        animals.add(hyena1);
        animals.add(lion1);
        animals.add(lion);

        hyena1.eat("banana");
        hyena.laugh();
        lion.eat("blueberries");
        lion1.roar();



        }
    }
