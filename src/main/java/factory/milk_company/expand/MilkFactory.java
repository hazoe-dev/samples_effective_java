package factory.milk_company.expand;

public class MilkFactory {
    public static String MILK_CHILDREN = "SP1";
    public static String MILK_MOTHER = "SP2";
    public static String MILK_THE_OLDER = "SP3";
    public Milk getMilk(String milkType){
        switch (milkType){
            case "SP1":
                return new MilkForChildren();
            case "SP2":
                return new MilkForTheElderly();
            case "SP3":
                return new MilkForPregnantMothers();
        }
        return null;
    }
}
