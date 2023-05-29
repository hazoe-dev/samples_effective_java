package shape_tool.composition;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Shape {
    String name;

    public String getName() {
        return name;
    }

    public String draw() {
        switch (name) {
            case "Circle.":
                return " */n" + "***/n" +" *";

            case "Rectangle.":
                return "***/n" + "***/n";
            default:
                return "Not define";
        }
    }
}
