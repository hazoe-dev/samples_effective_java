package shape_tool.lombok_deleget;

import lombok.experimental.Delegate;

public class Rectangle implements IShape {
    @Delegate
    Shape shape = new Shape("Rectangle.");
    int height;
    int weight;

    public Rectangle(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }
    @Override
    public int getArea() {
        return height * weight;
    }

    @Override
    public int getPerimeter() {
        return (height + weight) * 2;
    }
}
