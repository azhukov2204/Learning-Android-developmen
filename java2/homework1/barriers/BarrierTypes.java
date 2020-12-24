package java2.homework1.barriers;

public enum BarrierTypes {
    WALL("Стена"), RUNNING_TRACK("Беговая дорожка");

    private final String russianType;

    BarrierTypes(String russianType) {
        this.russianType = russianType;
    }

    public String getRussianType() {
        return russianType;
    }
}
