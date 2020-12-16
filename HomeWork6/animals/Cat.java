package homework6.animals;

public class Cat extends Animals {
    //"У каждого животного есть ограничения на действия":
    private final double CAT_MAX_RUN_DISTANCE=200; //бег: кот 200 м
    private final double CAT_MAX_JUMP_HEIGHT=2;    //прыжок: кот 2 м.

    //что умеют делать коты:
    private void catCanDo() {
        super.setCanJump(true);
        super.setCanRun(true);
        super.setCanSwim(false);
    }

    //Конструктор с дефолтными лимитами для кота:
    public Cat(String name, int age, String color) {
        super(name, age, color);
        catCanDo();
        super.setMaxJumpHeight(CAT_MAX_JUMP_HEIGHT);
        super.setMaxRunDistance(CAT_MAX_RUN_DISTANCE);
    }

    //для мощных и не очень котов можно задать свои лимиты:
    public Cat(String name, int age, String color, double maxRunDistance, double maxJumpDistance) {
        super(name, age, color);
        catCanDo();
        super.setMaxJumpHeight(maxJumpDistance);
        super.setMaxRunDistance(maxRunDistance);
    }

    public void voice() {
        System.out.println("Мяу! Меня зовут - " + super.name);
    }

    public void scratch() {
        System.out.println("Я могу царапать");
    }

}
