package skeletal_implementation.multiple_inheritance;

public class Card extends Payment{

    @Override
    public boolean pay() {
        System.out.println("Pay by card");
        return super.pay();
    }
}
