package inheritance_composition.lombok;

public class Circle implements IShape {
    IShape shape;
    double radius;

    public Circle(double radius) {
        this.radius = radius;
        shape = new Shape(this.getClass().getSimpleName());
    }

    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public String getName() {
        return shape.getName();
    }
}
