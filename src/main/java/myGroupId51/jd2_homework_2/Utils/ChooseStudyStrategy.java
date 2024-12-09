package myGroupId51.jd2_homework_2.Utils;

import myGroupId51.jd2_homework_2.Student;
import myGroupId51.jd2_homework_2.StudyStrategy.StudentType1;
import myGroupId51.jd2_homework_2.StudyStrategy.StudentType2;
import myGroupId51.jd2_homework_2.StudyStrategy.StudentType3;

public class ChooseStudyStrategy {
    public static String getStudyStrategy(Student student) {
        switch (student.getStudentType()) {
            case 1:
                StudentType1 studyStrategy1 = new StudentType1();
                studyStrategy1.calculateAllStudyTime(student);
                studyStrategy1.calculatePartStudyTime();
                return studyStrategy1.toString();
            case 2:
                StudentType2 studyStrategy2 = new StudentType2();
                studyStrategy2.calculateAllStudyTime(student);
                studyStrategy2.calculatePartStudyTime();
                return studyStrategy2.toString();
            case 3:
                StudentType3 studyStrategy3 = new StudentType3();
                studyStrategy3.calculateAllStudyTime(student);
                return studyStrategy3.toString();
        }
        return "Invalid student type";
    }
}
