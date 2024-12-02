package myGroupId51.jd2_homework_1.robots;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Dump {
    private static final int INITIAL_COUNT_OF_PARTS = 20; //Стартовое количество деталей на свалке
    private static final int PARTS_COUNT_MIN = 1; //Сколько деталей выбрасывает фабрика и сколько уносят с собой помощники ученых (макс. значение)
    private static final int PARTS_COUNT_MAX = 4; //Сколько деталей выбрасывает фабрика и сколько уносят с собой помощники ученых (мин. значение)
    private final List<RobotParts> dumpContainer; //Контейнер на свалке с деталями

    //Заполнение контейнера 20 случайными деталями
    public Dump() {
        this.dumpContainer = fillDump();
    }

    //Добавление детали в контейнер
    public void addPart(RobotParts part) {
        dumpContainer.add(part);
    }

    //Взятие детали из контейнера
    public RobotParts takeRandomPart() {
        int partIndex = ThreadLocalRandom.current().nextInt(dumpContainer.size());
        RobotParts robotPart = dumpContainer.get(partIndex);
        dumpContainer.remove(partIndex);
        return robotPart;
    }

    //Проверка, является ли контейнер пустым
    public boolean isEmpty() {
        return dumpContainer.isEmpty();
    }

    //Метод генерации 20 случайных деталей
    private List <RobotParts> fillDump() {
        List<RobotParts> parts = new ArrayList<>();
        for (int i = 0; i < INITIAL_COUNT_OF_PARTS; i++) {
            parts.add(RobotParts.getRandomPart());
        }
        return parts;
    }

    //Метод выдает от 1 до 4 случайных деталей
    public static int getSomeParts() {
        return ThreadLocalRandom.current().nextInt(PARTS_COUNT_MAX) + PARTS_COUNT_MIN;
    }
}
