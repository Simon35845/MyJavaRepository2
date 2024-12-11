package myGroupId51;

import myGroupId51.jd2_homework_2.FieldGenerators.StudentTalentGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTalentGeneratorTest {

    @Test
    void testRandomTalent(){
        double talent = StudentTalentGenerator.getRandomTalent();
        assertTrue(talent >= 0.1 && talent <= 1.0);
    }

}
