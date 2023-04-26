package common_method.lombok;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Book {
    @EqualsAndHashCode.Exclude private int publishingYear;
    @EqualsAndHashCode.Include static int count;//static -> lombok exclude
    //because static -> class memory: all variables have one value.
    public Book(int publishingYear) {
        this.publishingYear = publishingYear;
        count++;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Book.count = count;
    }

    public static void main(String[] args) {
        Book b1 = new Book(2012);
        Book b2 = new Book(2013);
        boolean result = b1.equals(b2);//true
    }

}
