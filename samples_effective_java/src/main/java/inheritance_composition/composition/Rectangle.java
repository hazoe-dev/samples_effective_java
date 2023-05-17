package inheritance_composition.composition;

public class Rectangle {
    IShape shape;
    private double length;
    private double weight;

    public Rectangle(double length, double weight) {
        this.length = length;
        this.weight = weight;
        shape = new Shape();
    }

    public double getPerimeter() {
        return (length + weight) * 2;
    }

    public double getArea() {
        return length * weight;
    }

    public String getName(){
        return shape.getName(this.getClass());
    }
}
