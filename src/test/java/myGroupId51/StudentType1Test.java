package myGroupId51;

import myGroupId51.jd2_homework_2.Students.Student;
import myGroupId51.jd2_homework_2.StudyStrategy.StudentType1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentType1Test {
    private StudentType1 studentType1;
    private Student student;

    @BeforeEach
    void setUp() {
        studentType1 = new StudentType1();
        student = new Student(1);
        student.setTalent(0.5);
    }

    @Test
    void testCalculateAllStudyTime() {
        double expected = 396.00;
        double actual = studentType1.calculateAllStudyTime(student);
        assertEquals(expected, actual, 0.01);
    }

    @Test
    void testCalculatePartStudyTime() {
        double expected = 132.00;
        studentType1.calculateAllStudyTime(student);
        double actual = studentType1.calculatePartStudyTime();
        assertEquals(expected, actual, 0.01);
    }
}
