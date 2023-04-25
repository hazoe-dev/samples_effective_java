package common_method.clone;

public class Chicken extends Food{
    private int weight;
    private int price;

    final int starChicken;
    public Chicken(int price ) {
        this.price = price;
        starChicken = 0;
    }

    public Chicken(int price, int starChicken ) {
        this.price = price;
        this.starChicken = 4;
    }

    @Override
    public String toString() {
        return "Chicken{" +
                "weight=" + weight +
                ", price=" + price +
                ", starChicken=" + starChicken +
                '}';
    }

    public static void main(String[] args) {
        Chicken c = new Chicken(12);
        Chicken c1 = new Chicken(12,3);

        try {
            Chicken cc= (Chicken) c1.clone();
            System.out.println(cc.toString());
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
