package myGroupId51.jd2_homework_1.task_71;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Task71 {
    public static void main(String[] args) {
        HelloWorld hw = new HelloWorld();
        try {
            Method mtd = HelloWorld.class.getDeclaredMethod("printHelloWorld");
            mtd.setAccessible(true);
            mtd.invoke(hw);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException();
        }
    }
}
