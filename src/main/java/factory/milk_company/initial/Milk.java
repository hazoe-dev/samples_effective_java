package factory.milk_company.initial;

import lombok.AllArgsConstructor;

import java.util.Date;
import java.util.Map;
@AllArgsConstructor
public class Milk {
    private int weight;
    private Date dateOfManufacture;

    private Map<String, Integer> recipe;
    private int price;

    public void box(Ingredient ingredient){
        ingredient.useACarton();
        System.out.println(weight +"gam milk + box " + weight );
    }

    public void label(Ingredient ingredient){
        ingredient.useASticker();
        System.out.println(dateOfManufacture.toString() +" prints on label ");
    }
}
