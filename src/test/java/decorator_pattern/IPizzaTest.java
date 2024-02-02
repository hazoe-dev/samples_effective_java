package decorator_pattern;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IPizzaTest {
    IPizza pizza;

    @Test
    void prepare_WhenPizzaIsBase_ReturnPizzaBase() {
        pizza = new BasePizza();
        Assertions.assertEquals("_Pizza base",pizza.prepare());
    }

    @Test
    void prepare_WhenPizzaIsBaseAndEgg_ReturnPizzaBase() {
        pizza = new EggPizza(new BasePizza());
        Assertions.assertEquals("_Pizza base_Egg",pizza.prepare());
    }

    @Test
    void prepare_WhenPizzaIsBaseAndMeat_ReturnPizzaBase() {
        pizza = new MeatPizza( new BasePizza());
        Assertions.assertEquals("_Pizza base_Meat",pizza.prepare());
    }

    @Test
    void prepare_WhenPizzaIsBaseAndEggAndMeat_ReturnPizzaBase() {
        pizza = new MeatPizza(new EggPizza(new BasePizza()));
        Assertions.assertEquals("_Pizza base_Egg_Meat",pizza.prepare());
    }
}