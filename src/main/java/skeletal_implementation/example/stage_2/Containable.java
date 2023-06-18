package skeletal_implementation.example.stage_2;

public interface Containable {
    void put (Item item);
    Item get(String name);
    void open();
    void close();
}
