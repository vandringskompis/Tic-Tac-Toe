public class Mammal implements Animal{

    private String name;

    public Mammal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;

    }


    public void getSound(String sound) {
       System.out.println(sound);

    }

    @Override
    public void getSound() {

    }

    @Override
    public String getType() {
        return "mammal";
    }
}
