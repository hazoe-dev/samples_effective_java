package common_method.lombok;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Book {
    @EqualsAndHashCode.Exclude private int publishingYear;
    
    public Book(int publishingYear) {
        this.publishingYear = publishingYear;
    }

    public static void main(String[] args) {
        Book b1 = new Book(2012);
        Book b2 = new Book(2013);
        boolean result = b1.equals(b2);//true
    }

}
