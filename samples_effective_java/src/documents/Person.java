package documents;

public class Person {
    int age;
    String name;

    public Person (int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name + "_" + this.age;
    }

    public static void main(String[] args) {
        int childAge = 4;
        String myName = "HaThiThuTran";

        Person childPerson = new Person(childAge, myName);
    }

}
