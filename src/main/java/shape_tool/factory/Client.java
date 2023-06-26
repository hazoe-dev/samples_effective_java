package shape_tool.factory;

public class Client {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();
        Shape shape1 = factory.getShape(ShapeFactory.CIRCLE);
        shape1.draw();

        Shape shape2 = factory.getShape(ShapeFactory.RECTANGLE);
        shape2.draw();

        Shape shape3 = factory.getShape(ShapeFactory.SQUARE);
        shape3.draw();
    }
}
