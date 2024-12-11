package myGroupId51;

import myGroupId51.jd2_homework_2.Students.Student;
import myGroupId51.jd2_homework_2.StudyStrategy.StudentType2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentType2Test {
    private StudentType2 studentType2;
    private Student student;

    @BeforeEach
    void setUp() {
        studentType2 = new StudentType2();
        student = new Student(2);
        student.setTalent(0.7);
    }

    @Test
    void testCalculateAllStudyTime() {
        double expected = 565.71;
        double actual = studentType2.calculateAllStudyTime(student);
        assertEquals(expected, actual, 0.01);
    }

    @Test
    void testCalculatePartStudyTime() {
        double expected = 282.86;
        studentType2.calculateAllStudyTime(student);
        double actual = studentType2.calculatePartStudyTime();
        assertEquals(expected, actual, 0.01);
    }
}
