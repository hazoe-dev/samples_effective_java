package skeletal_implementation.example.stage_1;

public class Client {
    public static void main(String[] args) {
        Bookshelf bookshelf = new Bookshelf();
        bookshelf.open();

        bookshelf.put(bookshelf.new Book("'Live 365 days a year'"));
        bookshelf.put(bookshelf.new Book("'The mountain is you'"));
        bookshelf.put(bookshelf.new Book("'Unlimited power'"));

        bookshelf.get("'Unlimited power'");

        bookshelf.close();
    }
}
