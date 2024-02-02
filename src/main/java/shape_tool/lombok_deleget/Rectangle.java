package shape_tool.lombok_deleget;

import lombok.experimental.Delegate;

public class Rectangle implements IShape {
    @Delegate
    Shape shape = new Shape("Rectangle.");
    int length;
    int width;

    public Rectangle(int length, int width) {
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
