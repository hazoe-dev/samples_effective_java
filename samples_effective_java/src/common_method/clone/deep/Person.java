package common_method.clone.deep;

import java.util.Objects;

public class Person implements Cloneable {
    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    protected Person clone() throws CloneNotSupportedException {
        Person p = (Person) super.clone();
        p.name = new String(name.getBytes().clone());
        return p;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && name != person.name && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + age;
        result = 31 * result + name.hashCode();
        return result;
    }
}
