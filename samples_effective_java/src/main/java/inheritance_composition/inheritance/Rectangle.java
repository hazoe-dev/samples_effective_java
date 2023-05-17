package inheritance_composition.inheritance;

public class Rectangle extends Shape{
    private double length;
    private double weight;

    public Rectangle(double length, double weight) {
        this.length = length;
        this.weight = weight;
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
