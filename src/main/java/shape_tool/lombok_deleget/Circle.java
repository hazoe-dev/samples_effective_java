package shape_tool.lombok_deleget;

import lombok.experimental.Delegate;

import java.util.Map;

public class Circle implements IShape{
    @Delegate
    Shape shape = new Shape("Circle.");
    int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public int getArea() {
        return (int) (radius * 2 * Math.PI);
    }

    @Override
    public int getPerimeter() {
        return (int) (radius * radius * Math.PI);
    }
}
