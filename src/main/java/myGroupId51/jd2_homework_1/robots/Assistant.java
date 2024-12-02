package myGroupId51.jd2_homework_1.robots;

public class Assistant implements Runnable {
    private static final int NIGHTS_COUNT = 100; //сколько ночей
    private static final int TIME_BETWEEN_NIGHTS = 100; //время между ночами (100 мс)
    private final Scientist scientist;
    private final Dump dump;

    public Assistant(Scientist scientist, Dump dump) {
        this.scientist = scientist;
        this.dump = dump;
    }

    //Работа помощника ученого (взять со свалки 1-4 случайные детали и принести ученому)
    @Override
    public void run() {
        for (int i = 0; i < NIGHTS_COUNT; i++) {
            int parts = Dump.getSomeParts();
            for (int j = 0; j < parts; j++) {
                synchronized (dump) {
                    if (!dump.isEmpty()) {
                        scientist.addPartToStorage(dump.takeRandomPart());
                    } else {
                        break;
                    }
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
