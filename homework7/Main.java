package homework7;

public class Main {
    public static void main(String[] args) {
        //создаем массив котов:
        Cat[] cats = new Cat[4];
        cats[0] = new Cat("Мурзик", 3, "Серый", 15);
        cats[1] = new Cat("Барсик", 4, "Белый",  7);
        cats[2] = new Cat("Борис", 2, "Рыжий"); //аппетит по-умолчанию.
        cats[3] = new Cat("Муся", 1, "Серый"); //аппетит по-умолчанию.

        //Вывод информации о котах:
        printCatsInfo(cats);

        //Создаем миску
        Plate plate = new Plate(30);

        //кормим котов
        catsFeeding(cats, plate);

        //Вывод информации о котах:
        printCatsInfo(cats);

        //информация о еде в миске:
        plate.info();

        //Добавим еды в миску:
        plate.increaseFood(4);

        //кормим котов
        catsFeeding(cats, plate);

        //Вывод информации о котах:
        printCatsInfo(cats);

        //информация о еде в миске:
        plate.info();

    }
    

    public static void printCatsInfo(Cat[] cats) {
        for (Cat cat : cats) {
            cat.voice();
        }
    }

    public static void catsFeeding(Cat[] cats, Plate plate) {
        for (Cat cat : cats) {
            cat.eat(plate);
        }
    }
        
}
