package factory.milk_company.expand;

import factory.milk_company.initial.Ingredient;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MilkForChildren implements Milk{
    private int weight = 200;
    private Date dateOfManufacture = new Date();

    private Map<String, Integer> recipe = new HashMap<>();

    private int price = 200;

    public void box(Ingredient ingredient){
        ingredient.useACarton();
        System.out.println(weight +"gam milk + box " + weight );
    }

    public void label(Ingredient ingredient){
        ingredient.useASticker();
        System.out.println(dateOfManufacture.toString() +" prints on label -- "+this.getClass().getSimpleName());
    }
    @Override
    public void productMilk(Ingredient ingredient) {
        recipe.put("vitamin a",1);
        recipe.put("water",0);
        recipe.put("canxi",2);
        recipe.put("fat",2);
        recipe.put("cacbohydrate",2);

        box(ingredient);
        label(ingredient);
    }


}
