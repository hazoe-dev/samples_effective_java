package skeletal_implementation.example.stage_3;


public class Client {
    public static void main(String[] args) {
        Containable bookshelf = new Bookshelf(" shelf ");
        bookshelf.open();

        bookshelf.put(new Item("'Live 365 days a year'"));
        bookshelf.put(new Item("'The mountain is you'"));
        bookshelf.put(new Item("'Unlimited power'"));

        bookshelf.get("'Unlimited power'");


        bookshelf.close();

        //*******************************************
        Containable closet = new Closet(" closet ");
        closet.open();

        closet.put(new Item("White shirt"));
        closet.put(new Item("Black pants"));

        closet.get("White shirt");

        closet.close();
    }
}
