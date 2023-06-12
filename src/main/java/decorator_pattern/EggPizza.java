package decorator_pattern;

public class EggPizza extends DecoratorPizza{
    public EggPizza(IPizza pizza) {
        super(pizza);
    }

    @Override
    public String prepare() {
        return super.prepare() + "_Egg";
    }
}
