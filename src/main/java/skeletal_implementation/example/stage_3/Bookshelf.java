package skeletal_implementation.example.stage_3;

import java.util.List;

public class Bookshelf extends Container {
    public Bookshelf(String name) {
        super(name);
    }

    @Override
    public void open() {
        System.out.println("<<<<  No need to open because it do not have door\n");
    }

    @Override
    public void close() {
        System.out.println("\n>>>>  No need to close because it do not have door");
    }
}
