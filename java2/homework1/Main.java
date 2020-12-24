package java2.homework1;

import java2.homework1.barriers.Barrier;
import java2.homework1.barriers.RunningTrack;
import java2.homework1.barriers.Wall;
import java2.homework1.participants.Cat;
import java2.homework1.participants.Human;
import java2.homework1.participants.Participant;
import java2.homework1.participants.Robot;

public class Main {
    public static void main(String[] args) {

        System.out.println("Создаем массив участников");
        Participant[] participants = {
                new Cat("Борис", 2, 200),
                new Robot("FEODOR", 0.5, 1000),
                new Human("Федор Михайлович", 1.5, 5000)
        };
        System.out.println("--------------------------");

        System.out.println("Создаем массив препятсивий");
        Barrier[] barriers = {
                new Wall(0.1),
                new RunningTrack(100),
                new Wall(1),
                new RunningTrack(1000),
                new Wall(1.5),
                new RunningTrack(2000)
        };
        System.out.println("--------------------------");

        System.out.println("Вывод информации о массиве препятствий:");
        int i=1;
        for (Barrier barrier : barriers) {
            System.out.print(i + ") ");
            barrier.showInfo();
            i++;
        }
        System.out.println("--------------------------");

        System.out.println("Начинаем состязания:");
        boolean isBreak;
        for (Participant participant : participants) {
            isBreak=false;
            participant.greeting(); //Приветствие участника
            for (Barrier barrier : barriers) {
                if(!participant.overcomeBarrier(barrier)) {
                    System.out.printf("Участник %s выбывает \n", participant.getName()); //есди не смог преодолеть препятсивие, то выбывает
                    isBreak=true;
                    break;
                }
            }
            if (!isBreak) {
                System.out.printf("Участник %s прошел все испытания!\n", participant.getName());
            }
            System.out.println("--------------------------");
        }
    }
}
