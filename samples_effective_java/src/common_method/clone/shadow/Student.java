package common_method.clone.shadow;

import java.util.Objects;

public class Student extends Person implements Cloneable{
    private String university;

    public Student(int age, String name, String university) {
        super(age, name);
        this.university = university;
    }

    @Override
    public Student clone() throws CloneNotSupportedException {
        return (Student) super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(university, student.university);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + super.hashCode();
        result = 31 * result + university.hashCode();
        return result;
    }
}
