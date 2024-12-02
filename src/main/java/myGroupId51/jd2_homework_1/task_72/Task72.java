package myGroupId51.jd2_homework_1.task_72;

import java.lang.reflect.Method;

public class Task72 {
    public static void main(String[] args) {
        for (Method mtd : TwoMethods.class.getDeclaredMethods()) {
            System.out.println("Метод " + mtd.getName() + " содержит аннотацию? " + mtd.isAnnotationPresent(AcademyInfo.class));
        }
    }
}
