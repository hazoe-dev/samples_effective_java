package inheritance_composition.inheritance;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MyClient {
    public static void main(String[] args) {
        Shape circle = new Circle(4.0);
        Shape rectangle = new Rectangle(2.0, 5.0);
        Shape square = new Square(4.0);

        List<Shape> shapes = new ArrayList<>();
        shapes.add(circle);
        shapes.add(rectangle);
        shapes.add(square);

        List<Double> areas = new ArrayList<>();
        areas = shapes.stream().map(shape -> shape.getArea()).collect(Collectors.toList());

        List<Double> perimeters = new ArrayList<>();
        perimeters = shapes.stream().map(Shape::getPerimeter).collect(Collectors.toList());

        List<String> names = new ArrayList<>();
        for (Shape shape: shapes ) {
            names.add(shape.getName());
        }
    }
}
