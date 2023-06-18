package skeletal_implementation.example.stage_1;

import java.util.ArrayList;
import java.util.List;

public class Bookshelf {
    private List<Book> books = new ArrayList<>();
    void open(){
        System.out.println("<<<<  No need to open because it do not have door\n");
    }
    Book get(String name){
        Book result =  books.stream().filter(item -> item.getName().equals(name)).findFirst().get();
        System.out.println("Take "+ result + " from the shelf");
        books.remove(result);
        return result;
    }
    void put(Book book){
        System.out.println("Put "+ book + " on the shelf");
        this.books.add(book);
    }
    void close(){
        System.out.println("\n>>>>  No need to close because it do not have door");
    }

    class Book{
        String name;

        public Book(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return " book " +name;
        }
    }
}
