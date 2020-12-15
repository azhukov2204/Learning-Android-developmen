package HomeWork6;

public class Dog extends Animals {

    //"У каждого животного есть ограничения на действия":
    private final double MAX_RUN_DISTANCE=500 ; //Бег: собака 500 м.
    private final double MAX_JUMP_HEIGHT=0.5;    //прыжок: собака 0.5 м.
    private final double MAX_SWIM_DISTANCE=10;    //плавание: собака 10 м

    //Конструктор с дефолтными лимитами для собаки:
    public Dog(String name, int age, String color) {
        super(name, age, color);
        super.setMaxJumpHeight(MAX_JUMP_HEIGHT);
        super.setMaxRunDistance(MAX_RUN_DISTANCE);
        super.setMaxSwimDistance(MAX_SWIM_DISTANCE);
    }

    //для мощных и не очень собачек можно задать свои лимиты:
    public Dog(String name, int age, String color, double maxRunDistance, double maxJumpDistance, double maxSwimDistance) {
        super(name, age, color);
        super.setMaxJumpHeight(maxJumpDistance);
        super.setMaxRunDistance(maxRunDistance);
        super.setMaxSwimDistance(maxSwimDistance);
    }

    public void voice() {
        System.out.println("Гав! Меня зовут - " + super.name);
    }
}
