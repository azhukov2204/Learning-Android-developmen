package java2.homework1.barriers;

public class Wall implements Barrier {
    private final double obstacleValue; //Высота стены (величина препятсивия)

    private final BarrierTypes barrierType=BarrierTypes.WALL;

    @Override
    public double getObstacleValue() {
        return obstacleValue;
    }

    public Wall(double obstacleValue) {
        this.obstacleValue = determineObstacleValue(obstacleValue);
    }

    @Override
    public String toString() {
        return "Стена высотой " + obstacleValue + " метров";
    }

    @Override
    public BarrierTypes getBarrierTypes() {
        return barrierType;
    }
}
