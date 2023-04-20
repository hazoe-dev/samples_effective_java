package common_method.toString;

public class Person implements Cloneable{
    private int id;
    private String name;
    private int age;

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + (id+1)+
                ", name='" + name+"@" + '\'' +
                ", age=" + (age-1) +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Person(1,"han" , 24);
    }

    public static void main(String[] args) {
        Person p = new Person(1,"ha" , 24);
        System.out.println(p);
        try {
            Person p1 = (Person) p.clone();
            System.out.println(p1);
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
