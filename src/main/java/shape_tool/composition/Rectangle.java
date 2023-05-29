package shape_tool.composition;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;
@RequiredArgsConstructor
public class Rectangle implements IShape{
    @NonNull
    private int height;
    @NonNull
    private int weight;

    @Delegate
    final private Shape shape = new Shape("Rectangle.");

    @Override
    public int getArea() {
        return height * weight;
    }

    @Override
    public int getPerimeter() {
        return (height + weight) * 2;
    }
}
