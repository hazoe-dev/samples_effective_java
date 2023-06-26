package shape_tool.factory;

public class ShapeFactory {
    public static final String CIRCLE= "Circle";
    public  static final String RECTANGLE= "Rectangle";
    public  static final String SQUARE= "Square";
    Shape getShape(String shapeType){
        switch (shapeType){
            case CIRCLE:
                return new Circle();
            case RECTANGLE:
                return new Rectangle();
            case SQUARE:
                return new Square();
        }
        return null;
    }
}
