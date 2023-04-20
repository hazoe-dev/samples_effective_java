package common_method;

import java.util.*;

public class ClassBone extends Animal implements Equitable{
    public ClassBone(String name, boolean havingBold, boolean livingInWater) {
        super(name, havingBold, livingInWater);
    }

    @Override
    public Map<Animal,String> addAnimal(Map<Animal,String> list, Animal animal) {
        list.put(animal,animal.getName());
        return list;
    }

    @Override
    public boolean equals(Object o) {
        if(!super.equals(o)) return false;

        Animal animal = (Animal) o;
        if(animal.livingInWater == true){
            return true;
        }
        return animal.havingBold == true && animal.livingInWater == false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, havingBold);
    }
}
