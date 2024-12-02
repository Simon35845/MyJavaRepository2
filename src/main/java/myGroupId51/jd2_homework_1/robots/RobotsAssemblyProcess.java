package myGroupId51.jd2_homework_1.robots;

public class RobotsAssemblyProcess {
    public static void main(String[] args) {
        Dump dump = new Dump();
        Scientist scientist1 = new Scientist("Ученый 1");
        Scientist scientist2 = new Scientist("Ученый 2");

        Thread factory = new Thread(new Factory(dump));
        Thread assistant1 = new Thread(new Assistant(scientist1, dump));
        Thread assistant2 = new Thread(new Assistant(scientist2, dump));

        factory.start();
        assistant1.start();
        assistant2.start();

        try {
            factory.join();
            assistant1.join();
            assistant2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }

        int result1 = scientist1.assembleRobots();
        int result2 = scientist2.assembleRobots();
        System.out.println(scientist1.getName() + " смог собрать " + result1 + " роботов");
        System.out.println(scientist2.getName() + " смог собрать " + result2 + " роботов");

        if (result1 > result2) {
            System.out.println("Победил " + scientist1.getName() + "!");
        } else if (result1 < result2) {
            System.out.println("Победил " + scientist2.getName() + "!");
        } else {
            System.out.println("Ничья!");
        }


    }
}
