package shape_tool.composition;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Client {
    public static void main(String[] args) {
        IShape circle = new Circle(5);
        IShape rectangle = new Rectangle(10,2);

        List<IShape> shapes = new ArrayList<>();
        shapes.add(circle);
        shapes.add(rectangle);

        shapes.forEach(shape -> System.out.println(shape.draw()));
        List<Integer> areas = shapes.stream().map(shape -> shape.getArea()).collect(Collectors.toList());
        List<Integer> perimeters = shapes.stream().map(IShape::getPerimeter).collect(Collectors.toList());
        List<String> names = shapes.stream().map(IShape::getName).collect(Collectors.toList());
    }
}
