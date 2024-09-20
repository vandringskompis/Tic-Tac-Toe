public class Rectangle {
    int x;
    int y;
    int width;
    int height;

    public Rectangle() {
        this.x = 0;
        this.y = 0;
        this.width = 0;
        this.height = 0;
    }

    public Rectangle (int width, int height){
        this.x = 0;
        this.y = 0;
        this.width = width;
        this.height = height;

    }

    public Rectangle (int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public double calculateArea() {
        double rectangleArea = (this.width * this.height);

        System.out.println("Area of rectangle: " + rectangleArea);
        return rectangleArea;
    }

    public double calculatePerimeter() {
        double perimeter = (this.width + this.height) * 2;

        System.out.println("Perimeter of rectangle: " + perimeter);
        return perimeter;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
