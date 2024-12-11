package myGroupId51.jd2_homework_2.Utils;

import myGroupId51.jd2_homework_2.Students.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentCreator {
    public static List<Student> createStudents() {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            students.add(new Student(1));
            students.add(new Student(2));
            students.add(new Student(3));
            students.add(new Student(4));
        }
        return students;
    }
}
