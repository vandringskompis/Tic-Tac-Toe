public class Dog implements Animal {
    @Override
    public void eat() {
        System.out.println("Dog eats");
    }

    @Override
    public void sound() {
        System.out.println("Dog says Woof woof");

    }
}
