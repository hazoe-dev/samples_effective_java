package common_method.clone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Food implements Cloneable{
    final int star = 4;
    private int weight;
    List<Chicken> chickens= new ArrayList<>();
    Chicken[] elements = new Chicken[3];
    private Food(int weight) {
        this.weight = weight;
    }

    public Food() {
    }

    @Override
    protected Food clone() throws CloneNotSupportedException {
        Food f = (Food) super.clone();

        f.elements = elements.clone();
        return f;
    }

    public static void main(String[] args) {
        Food f = new Food();
        Chicken c = new Chicken(10);
        Chicken c1 = new Chicken(11);
        Chicken c2 = new Chicken(12);
        f.chickens.add(c);
        f.chickens.add(c1);
        f.chickens.add(c2);

        f.elements[0]=c;
        f.elements[1]=c1;
        f.elements[2]=c2;
        System.out.println(f.chickens);
        System.out.println("Eles"+f.elements);
        System.out.println("Arr "+ Arrays.toString(f.elements));

        System.out.println(c);
        System.out.println(c1);
        System.out.println(c2);

        System.out.println(f);

        try {
            Food f1 = (Food) f.clone();
            System.out.println(f1);
            System.out.println(f1.chickens);
            for (Chicken chicken:f1.chickens
                 ) {
                System.out.println(chicken);
            }
            System.out.println("Arr f1 "+ Arrays.toString(f1.elements));

        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

    }
}
