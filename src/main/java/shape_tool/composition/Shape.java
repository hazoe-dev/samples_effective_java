package shape_tool.composition;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Shape implements IShape{
    String name;

    public String getName() {
        return name;
    }

    public String draw() {
        switch (name) {
            case "Circle.":
                return " ***\n" + "*****\n" +" ***\n";

            case "Rectangle.":
                return "*****\n" + "*****\n";
            default:
                return "Not define";
        }
    }

    @Override
    public int getArea() {
        return 0;
    }

    @Override
    public int getPerimeter() {
        return 0;
    }
}
