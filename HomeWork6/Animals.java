package HomeWork6;

public abstract class Animals {
    protected String name;    //имя животного
    protected int age;        //возраст
    protected String color;   //цвет

    //дополнительных логических переменных вводить не стал. Если значение лимита меньше 0 - значит животное это действие
    // выполнять не может:
    private double maxRunDistance=-1;
    private double maxJumpHeight=-1;
    private double maxSwimDistance=-1;

    public Animals(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public abstract void voice(); //у всех жимотных "голоса разные", поэтому метод делаю абстрактным

    //Добавлю сеттеры для установки ограничений на заявленные действия (эти свойства сделал private):
    public void setMaxRunDistance(double maxRunDistance) {
        this.maxRunDistance = maxRunDistance;
    }

    public void setMaxJumpHeight(double maxJumpHeight) {
        this.maxJumpHeight = maxJumpHeight;
    }

    public void setMaxSwimDistance(double maxSwimDistance) {
        this.maxSwimDistance = maxSwimDistance;
    }

    @Override
    public String toString() {
        return "Мое имя: " + name +
                ", мой возраст: " + age +
                ", мой цвет: " + color;
    }

    //собственно реализация заявленных методов run, jump и swim:
    public void run(double distance) {
        if (maxRunDistance<0) {
            System.out.println("Я не умею бегать");
        } else if (distance<0) {
            System.out.println("Введено отрицательное значение distance = " + distance);
        } else if (distance<=maxRunDistance) {
            System.out.printf("Я пробежал %.1f метров\n", distance);
        } else
        {
            System.out.println(distance + " - это слишком большое расстояние");
        }
    }

    public void jump(double height) {
        if (maxJumpHeight<0) {
            System.out.println("Я не умею прыгать");
        } else if (height<0) {
            System.out.println("Введено отрицательное значение height = " + height);
        } else if (height<=maxJumpHeight) {
            System.out.printf("Я прыгнул на высоту %.1f метра\n", height);
        } else {
            System.out.println(height + " - это слишком большая высота");
        }
    }


    public void swim(double distance) {
        if (maxSwimDistance<0) {
            System.out.println("Я не умею плавать");
        } else if (distance<0) {
            System.out.println("Введено отрицательное значение distance = " + distance);
        } else if (distance<=maxSwimDistance) {
            System.out.printf("Я проплыл %.1f метров\n", distance);
        } else {
            System.out.println(distance + " - это слишком большое расстояние");
        }
    }

}
