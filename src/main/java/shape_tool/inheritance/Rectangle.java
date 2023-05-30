package shape_tool.inheritance;

public class Rectangle extends Shape {
    private int height;
    private int weight;

    public Rectangle(int height, int weight,String name) {
        super(name);
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int getArea() {
        return height * weight;
    }

    @Override
    public int getPerimeter() {
        return (height + weight) * 2;
    }
}
