package factory.milk_company.initial;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Company {
    public static void main(String[] args) {
        Ingredient ingredient = new Ingredient(10, 10);

        Map<String, Integer> recipe = new HashMap<>();
        recipe.put("vitamin a",1);
        recipe.put("water",0);
        recipe.put("canxi",2);
        recipe.put("fat",2);
        recipe.put("cacbohydrate",2);

        Milk milk = new Milk(12,new Date(),recipe,200);
        milk.box(ingredient);
        milk.label(ingredient);
    }


}
