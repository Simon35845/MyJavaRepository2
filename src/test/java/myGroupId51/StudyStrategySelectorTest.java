package myGroupId51;

import myGroupId51.jd2_homework_2.Exceptions.InvalidStudentTypeException;
import myGroupId51.jd2_homework_2.Students.Student;
import myGroupId51.jd2_homework_2.StudyStrategy.StudentType1;
import myGroupId51.jd2_homework_2.StudyStrategy.StudentType2;
import myGroupId51.jd2_homework_2.StudyStrategy.StudentType3;
import myGroupId51.jd2_homework_2.StudyStrategy.StudyStrategy;
import myGroupId51.jd2_homework_2.Utils.StudyStrategySelector;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class StudyStrategySelectorTest {
    @Test
    void testGetStudyStrategy_Type1() throws InvalidStudentTypeException {
        Student student = new Student(1);
        StudyStrategy result = StudyStrategySelector.getStudyStrategy(student);
        assertNotNull(result);
        assertInstanceOf(StudentType1.class, result);
    }

    @Test
    void testGetStudyStrategy_Type2() throws InvalidStudentTypeException {
        Student student = new Student(2);
        StudyStrategy result = StudyStrategySelector.getStudyStrategy(student);
        assertNotNull(result);
        assertInstanceOf(StudentType2.class, result);
    }

    @Test
    void testGetStudyStrategy_Type3() throws InvalidStudentTypeException {
        Student student = new Student(3);
        StudyStrategy result = StudyStrategySelector.getStudyStrategy(student);
        assertNotNull(result);
        assertInstanceOf(StudentType3.class, result);
    }

    @Test
    void testGetStudyStrategy_InvalidType() {
        Student student = new Student(4);
        InvalidStudentTypeException exception = assertThrows(InvalidStudentTypeException.class, () ->
                StudyStrategySelector.getStudyStrategy(student));
        String expectedMessage = "Такого типа студента не существует.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
