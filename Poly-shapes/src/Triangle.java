public class Triangle extends Shape {
    public Triangle(double width, double height) {
        super(width, height);
    }

    @Override
    public double getArea() {
        return getWidth() * getHeight() * 0.5;
    }
}

