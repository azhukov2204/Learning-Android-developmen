package java2.homework1.participants;

public enum ParticipantsTypes {
    CAT("Кот"), ROBOT("Робот"), HUMAN("Человек");

    private final String russianParticipantTypes;

    ParticipantsTypes(String russianParticipansTypes) {
        this.russianParticipantTypes = russianParticipansTypes;
    }

    public String getRussianParticipantTypes() {
        return russianParticipantTypes;
    }
}
