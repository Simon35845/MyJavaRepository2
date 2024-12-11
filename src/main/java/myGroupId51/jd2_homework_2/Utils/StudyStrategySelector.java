package myGroupId51.jd2_homework_2.Utils;

import myGroupId51.jd2_homework_2.Exceptions.InvalidStudentTypeException;
import myGroupId51.jd2_homework_2.Students.Student;
import myGroupId51.jd2_homework_2.StudyStrategy.StudentType1;
import myGroupId51.jd2_homework_2.StudyStrategy.StudentType2;
import myGroupId51.jd2_homework_2.StudyStrategy.StudentType3;
import myGroupId51.jd2_homework_2.StudyStrategy.StudyStrategy;

public class StudyStrategySelector {
    public static StudyStrategy getStudyStrategy(Student student) throws InvalidStudentTypeException {
        switch (student.getStudentType()) {
            case 1:
                StudentType1 studyStrategy1 = new StudentType1();
                studyStrategy1.calculateAllStudyTime(student);
                studyStrategy1.calculatePartStudyTime();
                return studyStrategy1;
            case 2:
                StudentType2 studyStrategy2 = new StudentType2();
                studyStrategy2.calculateAllStudyTime(student);
                studyStrategy2.calculatePartStudyTime();
                return studyStrategy2;
            case 3:
                StudentType3 studyStrategy3 = new StudentType3();
                studyStrategy3.calculateAllStudyTime(student);
                return studyStrategy3;
            default:
                throw new InvalidStudentTypeException("Такого типа студента не существует.");
        }


    }
}
