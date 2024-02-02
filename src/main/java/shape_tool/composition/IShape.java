package shape_tool.composition;

public interface IShape {
    String draw();
    int getArea();
    int getPerimeter();

    String getName();
    interface ExcludeShape{
        int getArea();
        int getPerimeter();
    }
}

