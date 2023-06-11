package skeletal_implementation.interface_only;

public class EggPizza implements IPizza{
    IPizza pizza;
    public EggPizza(IPizza pizza) {
        this.pizza=pizza;
    }
    public String prepare() {
        return pizza.prepare()+ "_Egg";
    }
}
