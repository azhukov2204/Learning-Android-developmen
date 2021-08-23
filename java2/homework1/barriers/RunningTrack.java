package java2.homework1.barriers;

public class RunningTrack implements Barrier {
    private final double obstacleValue; //длина беговой дорожки (величина препятствия)

    private final BarrierTypes barrierType=BarrierTypes.RUNNING_TRACK;

    @Override
    public double getObstacleValue() {
        return obstacleValue;
    }

    public RunningTrack(double obstacleValue) {
        this.obstacleValue = determineObstacleValue(obstacleValue);
    }

    @Override
    public String toString() {
        return "Беговая дорожка длиной " + obstacleValue + " метров";
    }


    @Override
    public BarrierTypes getBarrierTypes() {
        return barrierType;
    }
}
