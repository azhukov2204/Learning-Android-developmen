package homework6.main;

import homework6.animals.Animals;
import homework6.animals.Cat;
import homework6.animals.Dog;

public class Main {
    public static void main(String[] args) {
        System.out.println("Домашнее задание №6");
        System.out.println("--------------------------------------------");
        //Создаем объекты Кот и Собака. Тестируем полиформизм, все объекты класса Animals:
        Animals myCat = new Cat("Мурзик", 3, "Серый");
        Animals myDog = new Dog("Рекс", 4, "Белый");


        System.out.println("Проверим, как наследовался переопределенный toString():");
        System.out.println(myCat);
        System.out.println(myDog);

        System.out.println("--------------------------------------------");
        System.out.println("Проверка методов run(), jump() и swim() в пределах мксимальных значений:");
        myCat.voice();
        myCat.jump(2);
        myCat.run(20);
        myCat.swim(20); //кот не умеет плавать, будет выдано сообщение "Я не умею плавать"

        myDog.voice();
        myDog.jump(0.3);
        myDog.run(22);
        myDog.swim(8); //

        System.out.println("--------------------------------------------");
        System.out.println("Проверка методов run(), jump() и swim() в за пределами максимальных значений:");
        myCat.voice();
        myCat.jump(3);
        myCat.run(201);
        myCat.swim(20); //кот не умеет плавать, будет выдано сообщение "Я не умею плавать"

        myDog.voice();
        myDog.jump(0.6);
        myDog.run(501);
        myDog.swim(11);

        System.out.println("--------------------------------------------");
        System.out.println("Добавим животным разброс в ограничениях. То есть у одной собаки ограничение на бег может быть 400 м., у другой 600 м.");

        //для этого создадим объекты с переопределенными лимитами
        //лимиты можно переопределить и у существующих объектов методами setMaxRunDistance(), setMaxJumpHeight(), setMaxSwimDistance()
        Animals powerfulDog = new Dog("Мухтар", 5, "Коричневый", 600, 1.5, 50);
        Animals weakDog = new Dog("Тузик", 1, "Белый>", 400, 0.3, 5);

        System.out.println("--------------------------------------------");
        System.out.println("Проверка методов run()");
        powerfulDog.voice();
        powerfulDog.run(600);   //в пределах лимита
        powerfulDog.run(601);   //превышение лимита

        weakDog.voice();
        weakDog.run(400);       //в пределах лимита
        weakDog.run(401);       //превышение лимита

        myCat.setMaxSwimDistance(10);
        myCat.swim(5);

        ((Cat)myCat).scratch(); //этот метод есть только в классе Cat, поэтому делаем приведение типа
    }
}
