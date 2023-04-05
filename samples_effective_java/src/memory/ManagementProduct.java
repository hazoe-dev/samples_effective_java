package memory;

import java.util.*;

public class ManagementProduct {
    int number = 10;
    List<Product>products;
    Integer[] list;
    public int getSizeProduct(){
        return products.size();
    }
    public void getSizeProductNotList(){
        List b = Arrays.asList(list);

        System.out.println(Collections.min(b));
        System.out.println(Collections.max(b));
    }
    public void createObject(int quality){
        products = new ArrayList<>();
        for (int i = 0; i < quality; i++) {
            products.add(new Product());
        }
    }
    public void createObjectNotArray(int quality){
        list = new Integer[quality];
        for (int i = 0; i < quality; i++) {
            list[i] = new Integer(i);
        }
    }
    public static void main(String[] args) {
        ManagementProduct m = new ManagementProduct();
        System.out.println("70 091 070");
//        try {
//            m.createObject(100000000);
//            System.out.println(m.getSizeProduct());
//        }catch (OutOfMemoryError e){
//            System.out.println("Error "+ e + m.getSizeProduct());
//        }
        try {
            m.createObjectNotArray(75_000_001);
        }catch (OutOfMemoryError e){
            e.printStackTrace();
        }
        m.getSizeProductNotList();
    }

}
