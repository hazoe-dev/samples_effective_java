package common_method.lombok;

import lombok.EqualsAndHashCode;
//luon chi dinh ro cac nao @EqualsAndHashCode.Include
@EqualsAndHashCode(callSuper=true)
public class Book extends Product{
    @EqualsAndHashCode.Exclude private int publishingYear;
    @EqualsAndHashCode.Include static int count;//static -> lombok exclude
    //because static -> class memory: all variables have one value.
    transient int transientVar = 10;
    public Book(int publishingYear, int quantity) {
        super(quantity);
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
        Book b1 = new Book(2012,2);
        Book b2 = new Book(2013,8);
        boolean result = b1.equals(b2);//true
        System.out.println(result);
    }

}

class Product{
    int quantity;

    public Product(int quantity) {
        this.quantity = quantity;
    }
}
