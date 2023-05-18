package inheritance_composition.lombok;

public class Rectangle implements IShape {
    IShape shape;
    private double length;
    private double weight;

    public Rectangle(double length, double weight) {
        this.length = length;
        this.weight = weight;
        shape = new Shape(this.getClass().getSimpleName());
    }

    @Override
    public String getName() {
        return shape.getName();
    }

    @Override
    public double getPerimeter() {
        return (length + weight) * 2;
    }

    @Override
    public double getArea() {
        return length * weight;
    }
}
