package myGroupId51.jd2_homework_2.Utils;

import myGroupId51.jd2_homework_2.Exceptions.InvalidStudentTypeException;
import myGroupId51.jd2_homework_2.Students.Student;
import myGroupId51.jd2_homework_2.StudyStrategy.StudyStrategy;

import java.util.List;

public class StudentPrinter {
    public static void printStudents() {
        List<Student> students = StudentCreator.createStudents();
        for (Student student : students) {
            try {
                StudyStrategy strategy = StudyStrategySelector.getStudyStrategy(student);
                System.out.println(student + "" + strategy);
            } catch (InvalidStudentTypeException e) {
                e.printStackTrace();
            }
        }
    }
}
