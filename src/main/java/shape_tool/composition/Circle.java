package shape_tool.composition;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;
@RequiredArgsConstructor
public class Circle implements IShape{
    @NonNull
    private int radius;
    @Delegate
    final private Shape shape = new Shape("Circle");

    @Override
    public int getArea() {
        return (int) (radius * radius * Math.PI);
    }

    @Override
    public int getPerimeter() {
        return (int) (2 * radius * Math.PI);
    }

}
