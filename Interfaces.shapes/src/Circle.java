public class Circle implements Shape{
   double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
       double circleArea = (radius * radius * Math.PI);
        return circleArea;
    }

    @Override
    public double perimeter() {
        double circlePerimeter = (2 * Math.PI * radius);
        return circlePerimeter;
    }
}
