package skeletal_implementation.abstract_interface;

public class MyClient {
    public static void main(String[] args) {
        IPizza pizza_base = new BasePizza();
        System.out.println(pizza_base.prepare());
        System.out.println(pizza_base.create());
        System.out.println("______________________");

        IPizza pizzaEgg = new EggPizza(new BasePizza());
        System.out.println(pizzaEgg.prepare());
        System.out.println(pizzaEgg.create());
        System.out.println("______________________");

        IPizza pizzaMeat = new MeatPizza(new BasePizza());
        System.out.println(pizzaMeat.prepare());
        System.out.println(pizzaMeat.create());
        System.out.println("______________________");

        IPizza pizzaEggMeat = new MeatPizza(new EggPizza(new BasePizza()));
        System.out.println(pizzaEggMeat.prepare());
        System.out.println(pizzaEggMeat.create());
    }
}
