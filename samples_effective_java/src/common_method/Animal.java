package common_method;

import java.util.Map;
import java.util.Objects;

public abstract class Animal implements Equitable{
    protected String name;
    protected boolean havingBold;
    protected boolean livingInWater;

    public Animal(String name, boolean havingBold, boolean livingInWater) {
        this.name = name;
        this.havingBold = havingBold;
        this.livingInWater = livingInWater;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHavingBold() {
        return havingBold;
    }

    public void setHavingBold(boolean havingBold) {
        this.havingBold = havingBold;
    }

    public boolean isLivingInWater() {
        return livingInWater;
    }

    public void setLivingInWater(boolean livingInWater) {
        this.livingInWater = livingInWater;
    }

    @Override
    public Map<Animal,String> addAnimal(Map<Animal,String> list, Animal animal) {
        list.put(animal,animal.getName());
        return list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(name, animal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
