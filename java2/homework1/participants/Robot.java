package java2.homework1.participants;

public class Robot implements Participant {
    private double maxJumpHeight;
    private double maxRunDistance;
    private final String name;
    private final ParticipantsTypes participantsType = ParticipantsTypes.ROBOT;

    public Robot(String name, double maxJumpHeight, double maxRunDistance) {
        this.name = name;
        this.maxJumpHeight=determineMaxJumpHeight(maxJumpHeight);
        this.maxRunDistance=determineMaxRunDistance(maxRunDistance);
    }


    @Override
    public String toString() {
        return  "Меня зовут " + name + ". " +
                "Я робот. Я могу прыгать на высоту " + maxJumpHeight + " метров. " +
                "Я могу пробежать " + maxRunDistance + " метров. ";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getMaxJumpHeight() {
        return maxJumpHeight;
    }

    @Override
    public double getMaxRunDistance() {
        return maxRunDistance;
    }

    @Override
    public ParticipantsTypes getParticipantsType() {
        return participantsType;
    }
}
