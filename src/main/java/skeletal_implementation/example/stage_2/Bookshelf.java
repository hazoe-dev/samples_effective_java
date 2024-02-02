package skeletal_implementation.example.stage_2;

import java.util.ArrayList;
import java.util.List;

public class Bookshelf implements Containable{
    List<Item> books= new ArrayList<>();
    @Override
    public void put(Item book) {
        System.out.println("Put "+ book + " on the shelf");
        this.books.add(book);
    }

    @Override
    public Item get(String name) {
        Item result =  books.stream().filter(item -> item.getName().equals(name)).findFirst().get();
        System.out.println("Take "+ result + " from the shelf");
        books.remove(result);
        return result;
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
