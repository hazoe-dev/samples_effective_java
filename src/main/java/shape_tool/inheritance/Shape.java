package shape_tool.inheritance;

public abstract class Shape {
    String name;

    public Shape(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String draw() {
        switch (name) {
            case "Circle.":
                return " ***\n" + "*****\n" + " ***\n";

            case "Rectangle.":
                return "*****\n" + "*****\n";
            default:
                return "Not define";
        }
    }

    abstract int getArea();

    abstract int getPerimeter();

}
