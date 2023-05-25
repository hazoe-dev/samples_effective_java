package shape_tool.lombok_deleget;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Client {
    public static void main(String[] args) {
        Circle circle = new Circle(4);
        Rectangle rectangle = new Rectangle(12,2);

        List<IShape> shapes = new ArrayList<>();
        shapes.add(circle);
        shapes.add(rectangle);

        List<String> names = shapes.stream().map(shape -> shape.getName()).collect(Collectors.toList());
        List<Integer> areas = shapes.stream().map(IShape::getArea).collect(Collectors.toList());
        List<Integer> perimeters = shapes.stream().map(IShape::getPerimeter).collect(Collectors.toList());
        shapes.forEach(shape -> shape.draw());

    }
}
