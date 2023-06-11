package skeletal_implementation.interface_only;

public class MeatPizza implements IPizza{
    IPizza pizza;
    public MeatPizza(IPizza pizza) {
        this.pizza=pizza;
    }
    public String prepare() {
        return pizza.prepare()+ "_Meat";
    }
}
