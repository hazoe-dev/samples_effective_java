package common_method.clone.deep;

import common_method.clone.deep.Student;

import java.sql.Struct;

public class School {

    public static void main(String[] args) throws CloneNotSupportedException {
        Student student = new Student(24, "ha", "TMA");
        Student clone = student.clone();

        boolean equal = student.equals(clone); //true
        boolean distinct = student!=clone;//true
        boolean className = student.getClass()==clone.getClass();//true
    }
}
