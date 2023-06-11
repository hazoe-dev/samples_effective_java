package skeletal_implementation.multiple_inheritance;

public class QuickPizza extends Payment{
    private class PrepayPizza extends DecoratorPizza{
        public PrepayPizza(IPizza pizza) {
            super(pizza);
        }
    }
    private PrepayPizza pizza;

    public QuickPizza(DecoratorPizza pizza) {
        this.pizza = new PrepayPizza(pizza);
    }

    @Override
    public boolean pay() {
        System.out.println("Quick pizza - prepay");
        return super.pay();
    }

    public String create() {
        return pizza.create();
    }
}
