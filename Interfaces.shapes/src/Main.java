//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

Circle circle = new Circle(3.0);
Rectangle rectangle = new Rectangle(4.0, 3.0);

        System.out.println(circle.area());
        System.out.println(circle.perimeter());

        System.out.println(rectangle.area());
        System.out.println(rectangle.perimeter());
    }
}