package shape_tool.composition;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;
public class Circle implements IShape{
    private int radius;
    @Delegate(excludes = ExcludeShape.class)
    private IShape shape;

    public Circle( int radius, IShape shape) {
        this.radius = radius;
        this.shape = shape;
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
