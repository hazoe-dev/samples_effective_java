package inheritance_composition.composition;

public class Shape implements IShape{
    public String getName(Class object) {
        return object.getClass().getSimpleName();
    }

}
