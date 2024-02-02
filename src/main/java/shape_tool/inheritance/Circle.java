package shape_tool.inheritance;

public class Circle extends Shape {
    private int radius;

    public Circle(int radius, String name) {
        super(name);
        this.radius = radius;
    }

    @Override
    public int getArea() {
        return (int) (radius * radius * Math.PI);
    }

    @Override
    public int getPerimeter() {
        return (int) (2 * radius * Math.PI);
    }

}
