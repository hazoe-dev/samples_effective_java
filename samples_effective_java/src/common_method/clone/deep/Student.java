package common_method.clone.deep;

import java.util.Arrays;
import java.util.Objects;

public class Student extends Person implements Cloneable{
    private String university;

    public Student(int age, String name, String university) {
        super(age, name);
        this.university = university;
    }

    @Override
    public Student clone() throws CloneNotSupportedException {
        Student s = (Student) super.clone();
        s.university = new String(this.university.getBytes().clone());
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return university!= ((Student) o).university && Objects.equals(university, student.university);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + super.hashCode();
        result = 31 * result + university.hashCode();
        return result;
    }
}
