package common_method.equal_hashcode.composition;

public class BookStore {
    public static void main(String[] args) {

        SelfHelp selfHelpBook = new SelfHelp( 100);
        Book book1 = new Book("Habits", 2019, "James",selfHelpBook);

        boolean b1 =selfHelpBook.equals(book1);//false : expected
        boolean b = book1.equals(selfHelpBook); //false

        System.out.println((b1==b) +" =>favor composition over inheritance." );
    }
}
