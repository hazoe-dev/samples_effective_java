package shape_tool.composition;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;
public class Rectangle implements IShape{

    private int height;
    private int weight;

    @Delegate(excludes = ExcludeShape.class)
    private IShape shape;

    public Rectangle(int height, int weight, IShape shape) {
        this.height = height;
        this.weight = weight;
        this.shape = shape;
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
