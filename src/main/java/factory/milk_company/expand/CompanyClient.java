package factory.milk_company.expand;

import factory.milk_company.initial.Ingredient;

public class CompanyClient {
    public static void main(String[] args) {
        Ingredient ingredient = new Ingredient(10, 10);

        MilkFactory factory = new MilkFactory();
        factory.getMilk(MilkFactory.MILK_CHILDREN).productMilk(ingredient);
        factory.getMilk(MilkFactory.MILK_MOTHER).productMilk(ingredient);
        factory.getMilk(MilkFactory.MILK_THE_OLDER).productMilk(ingredient);

    }
}
