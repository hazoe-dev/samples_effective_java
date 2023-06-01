package shape_tool.composition;

import lombok.experimental.Delegate;
public class Rectangle implements IShape{

    private int length;
    private int width;

    @Delegate(excludes = ExcludeShape.class)
    private IShape shape;

    public Rectangle(int length, int width, IShape shape) {
        this.length = length;
        this.width = width;
        this.shape = shape;
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
