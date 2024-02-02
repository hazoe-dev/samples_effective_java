package skeletal_implementation.abstract_interface;

public class MeatPizza extends DecoratorPizza {
    public MeatPizza(IPizza pizza) {
        super(pizza);
    }

    @Override
    public String prepare() {
        return super.prepare() + "_Meat";
    }
}
