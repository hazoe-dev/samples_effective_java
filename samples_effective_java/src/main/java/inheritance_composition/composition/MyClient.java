package inheritance_composition.composition;


import inheritance_composition.inheritance.Shape;

import java.util.ArrayList;
import java.util.List;

public class MyClient {
    public static void main(String[] args) {
        Circle circle = new Circle(4.0);
        Rectangle rectangle = new Rectangle(2.0, 5.0);

        List<Object> objects = new ArrayList<>();
        objects.add(circle);
        objects.add(rectangle);

        List<Double> areas = new ArrayList<>();
        for (Object obj : objects) {
            if (obj instanceof Circle) {
                areas.add(((Circle) obj).getArea());
            }
            if (obj instanceof Rectangle) {
                areas.add(((Rectangle) obj).getArea());
            }
        }
    }
}
