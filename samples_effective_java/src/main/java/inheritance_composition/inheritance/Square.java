package inheritance_composition.inheritance;

public class Square extends Shape{
    private double sideLength;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public double getPerimeter() {
        return sideLength * 4;
    }

    @Override
    public double getArea() {
        return sideLength * sideLength;
    }
}
