package decorator_pattern;

public class MyClient {
    public static void main(String[] args) {
        IPizza pizza_base = new BasePizza();
        System.out.println(pizza_base.prepare());

        IPizza pizzaEgg = new EggPizza(new BasePizza());
        System.out.println(pizzaEgg.prepare());

        IPizza pizzaMeat = new MeatPizza(new BasePizza());
        System.out.println(pizzaMeat.prepare());

        IPizza pizzaEggMeat = new MeatPizza(new EggPizza(new BasePizza()));
        System.out.println(pizzaEggMeat.prepare());
    }
}
