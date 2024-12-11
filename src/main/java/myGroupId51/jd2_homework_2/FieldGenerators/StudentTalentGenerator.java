package myGroupId51.jd2_homework_2.FieldGenerators;

public class StudentTalentGenerator {
    private static final double MIN_TALENT = 0.1;
    private static final double MAX_TALENT = 1.0;

    public static double getRandomTalent() {
        double random = MIN_TALENT + (Math.random() * (MAX_TALENT - MIN_TALENT));
        return Math.round(random * 10.0) / 10.0;
    }
}
