package java2.homework1.barriers;

public interface Barrier {

    double MIN_TRACK_DISTANCE=30;
    double MIN_WALL_HEIGHT=0.1;

    default double determineObstacleValue(double obstacleValue) {
        double unknownBarrierTypeObstacleValue=0;
        double newObstacleValue;
        switch (getBarrierTypes()) {
            case WALL:
                newObstacleValue=determineWallHeight(obstacleValue);
                break;
            case RUNNING_TRACK:
                newObstacleValue=determineRunningTrackLength(obstacleValue);
                break;
            default:
                System.out.println("Это неизвестное препятствие. Будет установлено значение " + unknownBarrierTypeObstacleValue);
                newObstacleValue=unknownBarrierTypeObstacleValue;
        }
        return newObstacleValue;
    }

    default double determineWallHeight(double obstacleValue) {
        if (obstacleValue < MIN_WALL_HEIGHT) {
            System.out.println(getBarrierTypes().getRussianType() + ": Высота стены не может быть меньше " + MIN_WALL_HEIGHT);
            System.out.println(getBarrierTypes().getRussianType() + ": Будет установлено значение " + MIN_WALL_HEIGHT);
            return MIN_WALL_HEIGHT;
        } else {
            return obstacleValue;
        }
    }

    default double determineRunningTrackLength(double obstacleValue) {
        if (obstacleValue < MIN_TRACK_DISTANCE) {
            System.out.println(getBarrierTypes().getRussianType() + ": Длина беговой дорожки не может быть меньше " + MIN_TRACK_DISTANCE);
            System.out.println(getBarrierTypes().getRussianType() + ": Будет установлено значение " + MIN_TRACK_DISTANCE);
            return MIN_TRACK_DISTANCE;
        } else {
            return obstacleValue;
        }
    }

    double getObstacleValue(); //получить величину препятствия

    default void showInfo() {
        System.out.println(this);
    }

    BarrierTypes getBarrierTypes();

}
