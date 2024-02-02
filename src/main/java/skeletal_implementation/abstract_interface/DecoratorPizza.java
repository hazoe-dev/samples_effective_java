package skeletal_implementation.abstract_interface;

public abstract class DecoratorPizza implements IPizza {
    protected IPizza pizza;

    public DecoratorPizza(IPizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String prepare() {
        return pizza.prepare();
    }

    @Override
    public boolean bake() {
        return pizza.bake();
    }

    @Override
    public boolean cut() {
        return pizza.cut();
    }

    @Override
    public boolean box() {
        return pizza.box();
    }

    @Override
    public String create() {
        return pizza.create();
    }
}
