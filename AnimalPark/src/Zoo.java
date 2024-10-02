import java.util.ArrayList;

public class Zoo {

    ArrayList<Animal> animalList = new ArrayList<>();


    public void addAnimal(Animal animal) {
        animalList.add(animal);

    }
    public void listAnimals() {
        for (Animal animal : animalList) {
            System.out.println(animal);
        }
    }


    Dog dog2 = new Dog("Harry");



}
