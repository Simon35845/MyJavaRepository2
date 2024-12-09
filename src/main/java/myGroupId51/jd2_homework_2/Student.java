package myGroupId51.jd2_homework_2;

import myGroupId51.jd2_homework_2.FieldGenerators.StudentNameGenerator;
import myGroupId51.jd2_homework_2.FieldGenerators.StudentTalentGenerator;

public class Student {
    private static final double COURSE_TIME = 198.0;
    private String name;
    private double talent;
    private int studentType;

    public Student(int studentType) {
        this.name = StudentNameGenerator.getRandomName().getName1();
        this.talent = StudentTalentGenerator.getRandomTalent();
        this.studentType = studentType;
    }

    public double getTalent() {
        return talent;
    }

    public int getStudentType() {
        return studentType;
    }

    public static double getCourseTime(){
        return COURSE_TIME;
    }

    @Override
    public String toString() {
        return "\nСтудент " + name +
                ", талант " + talent +
                ", тип студента " + studentType + ":";
    }
}

