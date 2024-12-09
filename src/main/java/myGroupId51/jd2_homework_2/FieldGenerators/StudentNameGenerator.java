package myGroupId51.jd2_homework_2.FieldGenerators;

public enum StudentNameGenerator {
    NAME_1("Денис"),
    NAME_2("Екатерина"),
    NAME_3("Алина"),
    NAME_4("Станислав"),
    NAME_5("Кристина"),
    NAME_6("Максим"),
    NAME_7("Владислав"),
    NAME_8("Вероника"),
    NAME_9("Даниил"),
    NAME_10("Анастасия"),
    NAME_11("Татьяна");

    private final String name;

    StudentNameGenerator(String name) {
        this.name = name;
    }

    public String getName1() {
        return name;
    }

    public static StudentNameGenerator getRandomName() {
        return StudentNameGenerator.values()[(int) (Math.random() * StudentNameGenerator.values().length)];
    }
}
