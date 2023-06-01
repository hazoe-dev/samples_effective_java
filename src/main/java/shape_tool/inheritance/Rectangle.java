package shape_tool.inheritance;

public class Rectangle extends Shape {
    private int length;
    private int width;

    public Rectangle(int length, int width, String name) {
        super(name);
        this.length = length;
        this.width = width;
    }

    @Override
    public int getArea() {
        return length * width;
    }

    @Override
    public int getPerimeter() {
        return (length + width) * 2;
    }
}
