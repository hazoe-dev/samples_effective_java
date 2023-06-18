package skeletal_implementation.example.stage_3;

import java.util.ArrayList;
import java.util.List;

public abstract class Container implements Containable {
    private String name;
    private List<Item> items = new ArrayList<>();

    public Container(String name) {
        this.name = name;
    }

    @Override
    public void put(Item book) {
        System.out.println("Put " + book + " on the " + name);
        this.items.add(book);
    }

    @Override
    public Item get(String name) {
        Item result = items.stream().filter(item -> item.getName().equals(name)).findFirst().get();
        System.out.println("Take " + result + " from the " + name);
        items.remove(result);
        return result;
    }
}
