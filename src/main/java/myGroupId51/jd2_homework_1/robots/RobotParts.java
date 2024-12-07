package myGroupId51.jd2_homework_1.robots;

import java.util.concurrent.ThreadLocalRandom;

public enum RobotParts {
    HEAD,
    BODY,
    RIGHT_HAND,
    LEFT_HAND,
    RIGHT_LEG,
    LEFT_LEG,
    CPU,
    RAM,
    HDD;

    //Метод, который выдает случайную деталь робота
    public static RobotParts getRandomPart() {
        int partIndex = ThreadLocalRandom.current().nextInt(RobotParts.values().length);
        return RobotParts.values()[partIndex];
    }
}
