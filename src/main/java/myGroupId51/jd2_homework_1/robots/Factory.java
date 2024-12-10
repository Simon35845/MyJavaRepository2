package myGroupId51.jd2_homework_1.robots;

public class Factory implements Runnable {
    private static final int NIGHTS_COUNT = 100; //сколько ночей
    private static final int TIME_BETWEEN_NIGHTS = 100; //время между ночами (100 мс)
    private final Dump dump;

    public Factory(Dump dump) {
        this.dump = dump;
    }

    //Работа фабрики (периодически выбрасывать на свалку от 1 до 4 случайных деталей)
    @Override
    public void run() {
        for (int i = 0; i < NIGHTS_COUNT; i++) {
            int parts = Dump.getSomeParts();
            for (int j = 0; j < parts; j++) {
                synchronized (dump) {
                    dump.addPart(RobotParts.getRandomPart());
                }
            }
            try {
                Thread.sleep(TIME_BETWEEN_NIGHTS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
