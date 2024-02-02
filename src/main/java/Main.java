import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static final Random rnd = new Random();
    // Common but deeply flawed!
    static int random(int n) {
        return Math.abs(rnd.nextInt()) % n;
    }
    public static void main(String[] args) {

        final BigDecimal TEN_CENTS = new BigDecimal( ".10");
        int itemsBought = 0;
        BigDecimal funds = new BigDecimal("1.00");
        for (BigDecimal price = TEN_CENTS;
             funds.compareTo(price) >= 0;
             price = price.add(TEN_CENTS)) {
            itemsBought++;
            funds = funds.subtract(price);
        }
        System.out.println(itemsBought + " items bought.");
        System.out.println("Money left over: $" + funds);
//        int n = 2 * (Integer.MAX_VALUE / 3);
//        int low = 0;
//        for (int i = 0; i < 1000000; i++)
//            if (random(n) < n/2)
//                low++;
//        System.out.println(low);
/*        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.print("Hello and welcome!");

        // Press Shift+F10 or click the green arrow button in the gutter to run the code.
        for (int i = 1; i <= 5; i++) {

            // Press Shift+F9 to start debugging your code. We have set one breakpoint
            // for you, but you can always add more by pressing Ctrl+F8.
            System.out.println("i = " + i);
        }
        Person p = new Person(12, "ha");
        try {
            p.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }*/

        ObjectInputStream o ;
        Class c = null;
        c.getName();
    }


}