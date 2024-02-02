package shape_tool.procedural;

import lombok.Builder;

@Builder(builderClassName = "BuilderShape")
public class GodShape {
    Integer length;
    Integer width;
    Integer radius;

    ShapeType type;

    public int getArea(){
        switch (type){
            case CIRCLE:
                return (int) (Math.PI * radius * radius);
            case RECTANGLE:
            case SQUARE:
                return length * width;
            default:
                System.out.println("Can not recognize shape type!");
                return 0;
        }
    }

    public int getPerimeter(){
        switch (type){
            case CIRCLE:
                return (int) (Math.PI * 2 * radius);
            case RECTANGLE:
            case SQUARE:
                return (length + width) * 2;
            default:
                System.out.println("Can not recognize shape type!");
                return 0;
        }
    }

    public String getName() {
        return type.getName();
    }
}
enum ShapeType {
    CIRCLE("Circle"),
    RECTANGLE("Rectangle"),
    SQUARE("Square");
    private String name;

    ShapeType(String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }
}
