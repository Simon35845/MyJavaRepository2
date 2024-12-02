package myGroupId51.jd2_homework_1.task_70;

public class Man {
    private String name;
    private int age;
    private String profession;
    private int salary;

    public Man(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Man(String name, int age, String profession, int salary) {
        this.name = name;
        this.age = age;
        this.profession = profession;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getProfession() {
        return profession;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    private void someInfo() {
        System.out.println("\tИмя: " + name +
                "\n\tВозраст: " + age + " года" +
                "\n\tПрофессия: " + profession +
                "\n\tЗарплата: " + salary + " руб.\n");
    }

}
