package HomeWork6;

public class Cat extends Animals {
    //"У каждого животного есть ограничения на действия":
    private final double CAT_MAX_RUN_DISTANCE=200; //бег: кот 200 м
    private final double CAT_MAX_JUMP_HEIGHT=2;    //прыжок: кот 2 м.

    //Конструктор с дефолтными лимитами для кота:
    public Cat(String name, int age, String color) {
        super(name, age, color);
        super.setMaxJumpHeight(CAT_MAX_JUMP_HEIGHT);
        super.setMaxRunDistance(CAT_MAX_RUN_DISTANCE);
    }

    //для мощных и не очень котов можно задать свои лимиты:
    public Cat(String name, int age, String color, double maxRunDistance, double maxJumpDistance) {
        super(name, age, color);
        super.setMaxJumpHeight(maxJumpDistance);
        super.setMaxRunDistance(maxRunDistance);
    }


    public void voice() {
        System.out.println("Мяу! Меня зовут - " + super.name);
    }

}
