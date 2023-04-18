package common_method;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ClassFish extends Animal implements Equitable{

    public ClassFish(String name, boolean havingBold, boolean livingInWater) {
        super(name, havingBold, livingInWater);
    }

    @Override
    public Map<Animal,String> addAnimal(Map<Animal,String> list,Animal animal) {
        list.put(animal,animal.getName());
        return list;
    }

    @Override
    public boolean equals(Object o) {
        if(!super.equals(o)) return false;

        Animal animal = (Animal) o;
        return true == animal.havingBold && true == animal.livingInWater;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, havingBold,livingInWater);
    }
}
