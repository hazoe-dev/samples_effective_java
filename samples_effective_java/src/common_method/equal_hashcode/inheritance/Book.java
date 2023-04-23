package common_method.equal_hashcode.inheritance;

import java.util.Objects;

public class Book {
    String name;
    int numberPublish;
    String author;

    public Book(String name, int numberPublish, String author) {
        this.name = name;
        this.numberPublish = numberPublish;
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        boolean nameEqual = (this.name == null && book.name==null)||(this.name!=null && this.name.equals(book.name));
        boolean authorEqual = (this.author == null && book.author==null)||(this.author!=null && this.author.equals(book.author));
        return numberPublish == book.numberPublish && nameEqual && authorEqual;
    }

    @Override
    public int hashCode() {
        int result= 17;
        result= 31 * result + numberPublish;
        result= 31 * result + name.length();
        result= 31 * result + author.length();
        return result;
    }
}
