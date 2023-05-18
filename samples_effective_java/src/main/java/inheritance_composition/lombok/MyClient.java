package inheritance_composition.lombok;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MyClient {
    public static void main(String[] args) {
        IShape circle = new Circle(4);
        IShape rectangle = new Rectangle(2, 5);

        List<IShape> shapes = new ArrayList<>();
        shapes.add(circle);
        shapes.add(rectangle);

        List<Double> areas = new ArrayList<>();
        areas = shapes.stream().map(shape -> shape.getArea()).collect(Collectors.toList());

        List<Double> perimeters = new ArrayList<>();
        perimeters = shapes.stream().map(IShape::getPerimeter).collect(Collectors.toList());

        List<String> names = new ArrayList<>();
        for (IShape shape : shapes) {
            names.add(shape.getName());
        }
    }
}
