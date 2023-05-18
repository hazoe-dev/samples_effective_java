package inheritance_composition.procedural;



import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MyClient {
    public static void main(String[] args) {
        Shape circle = new Shape.ShapeBuilder(Shape.CIRCLE).setRadius(4).build();
        Shape rectangle = new Shape.ShapeBuilder(Shape.RECTANGLE).setHeight(2).setWeight(5).build();

        List<Shape> shapes = new ArrayList<>();
        shapes.add(circle);
        shapes.add(rectangle);

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
