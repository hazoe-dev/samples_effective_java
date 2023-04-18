package common_method;

import java.util.HashMap;
import java.util.Map;

public class Zoo {
    public static void main(String[] args) {
        Animal fish = new ClassFish("Ca thu", true, true);
        Animal fish1 = new ClassFish("Ca thu", true, true);
        Animal bone1 = new ClassBone("Voi", true, false);

        Map<Animal,String> animals = new HashMap<>();
        fish.addAnimal(animals, fish);
        fish1.addAnimal(animals, fish1);
        bone1.addAnimal(animals, bone1);
        System.out.println(animals.keySet().size());
    }
}
