package inheritance_composition.composition;

public class Circle {
    IShape shape;
    double radius;

    public Circle(double radius) {
        this.radius = radius;
        shape = new Shape();
    }

    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public String getName(){
        return shape.getName(this.getClass());
    }
}
