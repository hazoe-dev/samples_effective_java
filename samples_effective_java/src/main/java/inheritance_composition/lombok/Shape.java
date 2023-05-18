package inheritance_composition.lombok;

public class Shape implements IShape {
    private String name;

    public Shape(String name) {
        this.name = name;
    }

    public String getName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public double getPerimeter() {
        return 0;
    }

    @Override
    public double getArea() {
        return 0;
    }

}
