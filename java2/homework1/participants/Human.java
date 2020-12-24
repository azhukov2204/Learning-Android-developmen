package java2.homework1.participants;

public class Human implements Participant {
    private double maxJumpHeight;
    private double maxRunDistance;
    private final String name;
    private final ParticipantsTypes participantsType = ParticipantsTypes.HUMAN;

    public Human(String name, double maxJumpHeight, double maxRunDistance) {
        this.name = name;
        this.maxJumpHeight=determineMaxJumpHeight(maxJumpHeight);
        this.maxRunDistance=determineMaxRunDistance(maxRunDistance);
    }

    @Override
    public String toString() {
        return  "Меня зовут " + name + ". " +
                "Я человек. Я могу прыгать на высоту " + maxJumpHeight + " метров. " +
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
