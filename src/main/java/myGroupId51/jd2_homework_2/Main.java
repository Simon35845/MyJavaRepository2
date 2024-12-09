package myGroupId51.jd2_homework_2;

import myGroupId51.jd2_homework_2.Utils.ChooseStudyStrategy;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            students.add(new Student(1));
            students.add(new Student(2));
            students.add(new Student(3));
        }

        for (Student student : students) {
            System.out.println(student + ChooseStudyStrategy.getStudyStrategy(student));
        }
    }
}
