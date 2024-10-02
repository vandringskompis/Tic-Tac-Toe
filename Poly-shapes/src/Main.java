import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        ArrayList<Shape> shapes = new ArrayList<>();

        Rectangle rec1 = new Rectangle(2.0, 4.0);
        Triangle tri1 = new Triangle(7.0, 2.0);

        shapes.add(tri1);
        shapes.add(rec1);


        System.out.println(rec1.getArea());
        System.out.println(tri1.getArea());

    }

}