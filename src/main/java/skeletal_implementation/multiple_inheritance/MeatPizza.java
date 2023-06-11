package skeletal_implementation.multiple_inheritance;

public class MeatPizza extends DecoratorPizza {
    public MeatPizza(IPizza pizza) {
        super(pizza);
    }

    @Override
    public String prepare() {
        return super.prepare() + "_Meat";
    }
}
