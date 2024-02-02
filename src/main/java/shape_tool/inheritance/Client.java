package shape_tool.inheritance;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Client {
    public static void main(String[] args) {
        Shape circle = new Circle(5, "Circle.");
        Shape rectangle = new Rectangle(10, 2, "Rectangle.");

        List<Shape> shapes = new ArrayList<>();
        shapes.add(circle);
        shapes.add(rectangle);


        shapes.forEach(shape -> System.out.println(shape.draw()));
        List<Integer> areas = shapes.stream().map(shape -> shape.getArea()).collect(Collectors.toList());
        List<Integer> perimeters = shapes.stream().map(Shape::getPerimeter).collect(Collectors.toList());
        List<String> names = shapes.stream().map(Shape::getName).collect(Collectors.toList());
    }

}
