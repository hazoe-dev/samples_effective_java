package documents;

import java.util.Objects;

public class Person implements Cloneable{
    int age;
    String name;

    public Person (int specificAge , String specificName)
    {
        this.age = specificAge;
        this.name = specificName;
    }

    @Override
    public String toString() {
        return this.name + "_" + this.age;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        int childAge = 4;
        String myName = "HaTran";

        Person childPerson = new Person(childAge, myName);
        Person childPerson1 = (Person) childPerson.clone();
    }
    @Override
    public Person clone() throws CloneNotSupportedException {
        return (Person) super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }
}
