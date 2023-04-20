package documents;

public class Person {
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

    public static void main(String[] args) {
        int childAge = 4;
        String myName = "HaTran";

        Person childPerson = new Person(childAge, myName);
    }

}
