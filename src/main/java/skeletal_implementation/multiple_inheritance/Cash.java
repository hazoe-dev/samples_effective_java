package skeletal_implementation.multiple_inheritance;

public class Cash extends Payment{
    @Override
    public boolean pay() {
        System.out.println("Pay by cash");
        return super.pay();
    }
}
