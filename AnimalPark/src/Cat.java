public class Cat extends Mammal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void getSound(String sound) {
        System.out.println(sound);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getType() {
        return super.getType();
    }
}
