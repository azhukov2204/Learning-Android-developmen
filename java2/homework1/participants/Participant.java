package java2.homework1.participants;
import java2.homework1.barriers.Barrier;
import java2.homework1.barriers.BarrierTypes;


public interface Participant {
    double MAX_RUN_DISTANCE=10000;
    double MIN_RUN_DISTANCE=0;
    double MAX_JUMP_HEIGHT=3;
    double MIN_JUMP_HEIGHT=0;

    default boolean jump(Barrier barrier) {
        if (barrier.getBarrierTypes()!= BarrierTypes.WALL) {
            System.out.println("Я умею прыгать только через стену");
            return false;
        } else {
            double jumpHeight = barrier.getObstacleValue();
            if (jumpHeight<=getMaxJumpHeight()) {
                System.out.printf("Я %s %s. Я прыгнул на высоту %.1f метров\n", getParticipantsType().getRussianParticipantTypes(), getName(), jumpHeight);
                return true;
            } else {
                System.out.printf("Я %s %s. Я не смог прыгнуть на высоту %.1f метров\n", this.getParticipantsType().getRussianParticipantTypes(), this.getName(), jumpHeight);
                return false;
            }
        }
    }


    default boolean run(Barrier barrier) {
        if (barrier.getBarrierTypes()!=BarrierTypes.RUNNING_TRACK) {
            System.out.println("Я умею бегать только по беговой дорожке");
            return false;
        } else {
            double runDistance = barrier.getObstacleValue();
            if (runDistance <= getMaxRunDistance()) {
                System.out.printf("Я %s %s. Я пробежал дистанцию длиной %.1f метров\n", getParticipantsType().getRussianParticipantTypes(), getName(), runDistance);
                return true;
            } else {
                System.out.printf("Я %s %s. Я не смог  пробежать дистанцию %.1f метров\n", getParticipantsType().getRussianParticipantTypes(), getName(), runDistance);
                return false;
            }
        }
    }

    default boolean overcomeBarrier(Barrier barrier) { //обобщенный метод. Сам выбирает, каким способом преодолеть препятствие.
        if (barrier.getBarrierTypes()==BarrierTypes.WALL) {
            return jump(barrier);                 //
        } else if (barrier.getBarrierTypes()==BarrierTypes.RUNNING_TRACK) {
            return run(barrier);         //
        } else {
            System.out.printf("Я %s %s. Это неизвестное препятствие! \n", getParticipantsType().getRussianParticipantTypes(), getName());
            return false;
        }
    }


    default double determineMaxRunDistance(double maxRunDistance) {
        if (maxRunDistance<MIN_RUN_DISTANCE) {
            System.out.println(getName() + ": Максимальная дистанция не может быть меньше "+ MIN_RUN_DISTANCE);
            System.out.println(getName() + ": Будет установлено значение maxRunDistance = "+ MIN_RUN_DISTANCE);
            return MIN_RUN_DISTANCE;
        } else if (maxRunDistance>MAX_RUN_DISTANCE) {
            System.out.println(getName() + ": Максимальная дистанция не может быть больше "+ MAX_RUN_DISTANCE);
            System.out.println(getName() + ": Будет установлено значение maxRunDistance = "+ MAX_RUN_DISTANCE);
            return MAX_RUN_DISTANCE;
        } else {
            return maxRunDistance;
        }
    }

    default double determineMaxJumpHeight(double maxJumpHeight) {
        if (maxJumpHeight<MIN_JUMP_HEIGHT) {
            System.out.println(getName() + ": Максимальная высота не может быть меньше "+ MIN_JUMP_HEIGHT);
            System.out.println(getName() + ": Будет установлено значение maxJumpHeight = "+ MIN_JUMP_HEIGHT);
            return MIN_JUMP_HEIGHT;
        } else if (maxJumpHeight>MAX_JUMP_HEIGHT) {
            System.out.println(getName() + ": Максимальная высота не может быть больше "+ MAX_JUMP_HEIGHT);
            System.out.println(getName() + ": Будет установлено значение maxJumpHeight = "+ MAX_JUMP_HEIGHT);
            return MAX_JUMP_HEIGHT;
        } else {
            return maxJumpHeight;
        }
    }

    default void greeting() {
        System.out.println(this);
    }

    double getMaxJumpHeight();
    double getMaxRunDistance();
    String getName();
    ParticipantsTypes getParticipantsType();

}
