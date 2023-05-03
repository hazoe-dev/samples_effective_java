package common_method.equal_hashcode.goodHashCode;

public class BookStore {
    public static void main(String[] args) {
        Book book1 = new Book("Habits", 2019, "James");
        SelfHelp selfHelpBook = new SelfHelp("Habits", 2019, "James", 100);

        boolean b1 =selfHelpBook.equals(book1);//false : expected
        boolean b = book1.equals(selfHelpBook); //false

        System.out.println((b1==b) +" =>Good hashCode" );
    }
}
