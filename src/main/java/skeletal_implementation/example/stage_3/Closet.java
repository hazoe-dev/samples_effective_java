package skeletal_implementation.example.stage_3;

import java.util.List;

public class Closet extends Container{
    private boolean opened;
    public Closet(String name) {
        super(name);
    }

    @Override
    public void open() {
        if(!opened){
            System.out.println("<<<<  Open the door\n");
            opened = true;
        }
    }

    @Override
    public void close() {
        if(opened) {
            System.out.println("\n>>>>  Close the door");
            opened = false;
        }
    }
}
