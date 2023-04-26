package common_method.clone;

public class Store {
    public static void main(String[] args) throws CloneNotSupportedException {
        Origin origin = new Origin("HCM");
        Pig p = new Pig(12, origin);
        Pig pig = p.clone();

        System.out.println(p+","+p.origin);
        System.out.println(pig+","+pig.origin);
    }
}
class Origin{
    String origin;

    public Origin(String origin) {
        this.origin = origin;
    }
}
