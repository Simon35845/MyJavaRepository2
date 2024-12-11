package myGroupId51;

import myGroupId51.jd2_homework_2.Students.Student;
import myGroupId51.jd2_homework_2.StudyStrategy.StudentType3;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentType3Test {
    private StudentType3 studentType3;
    private Student student;

    @BeforeEach
    void setUp() {
        studentType3 = new StudentType3();
        student = new Student(3);
        student.setTalent(0.9);
    }

    @Test
    void testCalculateAllStudyTime() {
        double expected = 660.00;
        double actual = studentType3.calculateAllStudyTime(student);
        assertEquals(expected, actual, 0.01);
    }
}
