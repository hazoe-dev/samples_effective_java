package shape_tool.procedural;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Client {
    public static void main(String[] args) {
        GodShape rectangle = GodShape.builder().length(12).width(2).type(ShapeType.RECTANGLE).build();
        GodShape circle = GodShape.builder().radius(5).type(ShapeType.CIRCLE).build();

        List<GodShape> shapes = new ArrayList<>();
        shapes.add(circle);
        shapes.add(rectangle);

        List<Integer> areas = shapes.stream().map(shape -> shape.getArea()).collect(Collectors.toList());
        List<Integer> perimeters = shapes.stream().map(shape -> shape.getPerimeter()).collect(Collectors.toList());
        List<String> names = shapes.stream().map(shape -> shape.getName()).collect(Collectors.toList());
    }
}
