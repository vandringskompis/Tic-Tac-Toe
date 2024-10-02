public class Rectangle implements Shape {
   double width;
   double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        double rectangleArea = width * height;
        return rectangleArea;
    }

    @Override
    public double perimeter() {
        double rectangleperimeter = (width + height) * 2;
        return rectangleperimeter;
    }
}
