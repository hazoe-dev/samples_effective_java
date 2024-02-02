package skeletal_implementation.example.stage_2;

import java.util.ArrayList;
import java.util.List;

public class Closet implements Containable{
    List<Item> books= new ArrayList<>();
    boolean opened;
    @Override
    public void put(Item book) {
        System.out.println("Put "+ book + " on the closet");
        this.books.add(book);
    }

    @Override
    public Item get(String name) {
        Item result =  books.stream().filter(item -> item.getName().equals(name)).findFirst().get();
        System.out.println("Take "+ result + " from the closet");
        books.remove(result);
        return result;
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
