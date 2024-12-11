package myGroupId51.jd2_homework_2.StudyStrategy;

import myGroupId51.jd2_homework_2.Students.Student;

public class StudentType3 implements StudyStrategy {
    private static final int STUDY_TIME_MULTIPLIER = 3;
    private static double allStudyTime;

    @Override
    public double calculateAllStudyTime(Student student) {
        double studyHours = Student.getCourseTime() / student.getTalent() * STUDY_TIME_MULTIPLIER;
        allStudyTime =  Math.round(studyHours * 100.0) / 100.0;
        return allStudyTime;
    }

    @Override
    public String toString() {
        return "\n\tна освоение всего курса потрачено " + allStudyTime + " часов, " +
                "\n\tна практическую часть потрачено " + allStudyTime + " часов.";
    }
}

