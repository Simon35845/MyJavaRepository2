package myGroupId51.jd2_homework_2.StudyStrategy;

import myGroupId51.jd2_homework_2.Students.Student;

public class StudentType2 implements StudyStrategy {
    private static final int TYPES_OF_LESSONS = 2;
    private static final int STUDY_TIME_MULTIPLIER = 2;
    private static double allStudyTime;
    private static double partStudyTime;

    @Override
    public double calculateAllStudyTime(Student student) {
        double studyHours = Student.getCourseTime() / student.getTalent() * STUDY_TIME_MULTIPLIER;
        allStudyTime =  Math.round(studyHours * 100.0) / 100.0;
        return allStudyTime;
    }

    public double calculatePartStudyTime() {
        double studyHours = allStudyTime / TYPES_OF_LESSONS;
        partStudyTime =  Math.round(studyHours * 100.0) / 100.0;
        return partStudyTime;
    }

    @Override
    public String toString() {
        return "\n\tна освоение всего курса потрачено " + allStudyTime + " часов, " +
                "\n\tна практическую часть потрачено " + partStudyTime + " часов, " +
                "\n\tна разборы потрачено " + partStudyTime + " часов.";
    }
}
