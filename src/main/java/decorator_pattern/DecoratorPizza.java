package decorator_pattern;

public abstract class DecoratorPizza implements IPizza{
    protected IPizza pizza;

    public DecoratorPizza(IPizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String prepare() {
        return pizza.prepare();
    }
}
