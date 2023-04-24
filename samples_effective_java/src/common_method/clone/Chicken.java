package common_method.clone;

public class Chicken extends Food{
    private int weight;
    private int price;

    public Chicken(int price) {
        this.price = price;
    }

    public static void main(String[] args) {
        Chicken c = new Chicken(12);
    }
}
