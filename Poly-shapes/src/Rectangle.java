public class Rectangle extends Shape {
    public Rectangle(double width, double height) {
        super(width, height);
    }

    @Override
    public double getArea() {
        return getWidth() * getHeight();
    }


}
