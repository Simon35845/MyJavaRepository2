package myGroupId51.jd2_homework_1.task_70;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

public class Task70 {

    public static void main(String[] args) {
        Man man1 = new Man("Павел", 24, "грузчик", 1500);
        man1.setSalary(1900);

        classInfo(man1);

        System.out.println("Вызов приватного метода");
        try {
            Method mtd = Man.class.getDeclaredMethod("someInfo");
            mtd.setAccessible(true);
            mtd.invoke(man1);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException();
        }
    }

    private static void classInfo(Man man1) {
        Class class1 = man1.getClass();
        System.out.println("Имя класса: " + class1.getSimpleName());

        System.out.println("\n" + "Приватные поля класса " + class1.getSimpleName() + ":");
        for (Field field: class1.getDeclaredFields()) {
            String fieldModifName = Modifier.toString(field.getModifiers());
            System.out.println("\t" + fieldModifName + " " + field.getType().getSimpleName() + " " + field.getName());
        }

        System.out.println("\n" + "Конструкторы класса " + class1.getSimpleName() + ":");
        for (Constructor constructor: class1.getDeclaredConstructors()) {
            String constrModifName = Modifier.toString(constructor.getModifiers());
            System.out.print("\t" + constrModifName + " " + constructor.getDeclaringClass().getSimpleName() + "(");
            for (Parameter parameter: constructor.getParameters()) {
                System.out.print(parameter.getType().getSimpleName() + " " + parameter.getName() + ", ");
            }
            System.out.println(")");
        }

        System.out.println("\n" + "Методы класса " + class1.getSimpleName() + " :");
        for (Method method: class1.getDeclaredMethods()) {
            String methodModifName = Modifier.toString(method.getModifiers());
            System.out.print("\t" + methodModifName + " " + method.getReturnType().getSimpleName() + " " + method.getName() + "(");
            for (Parameter parameter: method.getParameters()) {
                System.out.print(parameter.getType().getSimpleName() + " " + parameter.getName()+ ", ");
            }
            System.out.println(")");
        }
        System.out.println();
    }
}
