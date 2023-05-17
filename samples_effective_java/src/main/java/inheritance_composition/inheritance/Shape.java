package inheritance_composition.inheritance;

public abstract class Shape {
    public String getName() {
        return this.getClass().getSimpleName();
    }
    public abstract double getPerimeter();
    public abstract double getArea();

}
