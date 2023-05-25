package shape_tool.lombok_deleget;

public class Shape {
    String name;

    public Shape(String name) {
        this.name = name;
    }

    public void draw() {
        switch (name) {
            case "Circle.":
                System.out.println("     ******\n" +
                        "   **********\n" +
                        "  ************\n" +
                        "   **********\n" +
                        "     ******");
                break;
            case "Rectangle.":
                System.out.println("*********\n" +
                                "*********\n" +
                                "*********");
                break;
            default:
                System.out.println("Not define");
        }
    }

    public String getName() {
        return name;
    }
}
