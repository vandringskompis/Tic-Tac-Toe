//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
/*
Uppgift: Djurpark
Du ska skapa ett system för att hantera djur i en djurpark. Du kommer att använda arv och interfaces
för att strukturera din kod på ett objektorienterat sätt.

#### 1. Skapa ett Interface

Skapa ett interface Animal med följande metoder:
void makeSound(): Gör ett ljud.
String getType(): Returnerar typen av djuret.

#### 2. Skapa Bas- och Subklasser

Skapa en abstrakt bas-klass Mammal som implementerar Animal. Den ska ha:
Ett attribut name av typen String.
En konstruktor som tar ett namn som parameter.
En getter-metod för name.
Implementationen för getType som returnerar "Mammal".

Skapa två subklasser Dog och Cat som ärver från Mammal:
Dog ska implementera makeSound och skriva ut "Woof!".
Cat ska implementera makeSound och skriva ut "Meow!".

#### 3. Skapa en Klass för att Hantera Djur

Skapa en klass Zoo som hanterar en lista av djur:
Använd en ArrayList<Animal> för att lagra djuren.
Lägg till metoder för att:
Lägga till ett djur (addAnimal(Animal animal)).
Lista alla djur och deras ljud (listAnimals()).

#### 4. Testa Systemet

Skapa en Main-klass för att testa ditt system:
Skapa en instans av Zoo.
Lägg till några Dog och Cat-objekt till djurparken.
Anropa metoden listAnimals för att visa alla djur och deras ljud.
 */


public class Main {
    public static void main(String[] args) {

        Zoo myZoo = new Zoo();

        Dog dog1 = new Dog("Hopp");
        Cat cat1 = new Cat("Miss");

        dog1.getSound("Dog says Woof");
        System.out.println(cat1.getName());
        cat1.getSound("Cat says meow");
        System.out.println(cat1.getType());

        myZoo.addAnimal(dog1);
        myZoo.addAnimal(cat1);

        myZoo.listAnimals();



    }
}