package myGroupId51.jd2_homework_1.robots;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Scientist {
    private final String name;

    public Scientist(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private final Map<RobotParts, Integer> partsStorage = new HashMap<>();

    //Добавление детали в хранилище деталей
    public void addPartToStorage(RobotParts part) {
        if (partsStorage.containsKey(part)) {
            int count = partsStorage.get(part) + 1;
            partsStorage.put(part, count);
        } else {
            partsStorage.put(part, 1);
        }
    }

    //Сколько роботов можно собрать из имеющихся деталей
    public int assembleRobots() {
        for (RobotParts part : RobotParts.values()) {
            if (!partsStorage.containsKey(part)) {
                return 0;
            }
        }
        return Collections.min(partsStorage.values());
    }
}
