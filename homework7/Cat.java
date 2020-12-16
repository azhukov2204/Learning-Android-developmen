package homework7;

public class Cat {
    private String name;
    private int age;
    private String color;

    private boolean wellFed=false;  //сытость (коты создаются голодными)
    private int appetite=10;        //аппетит (и значение по-умолчанию)

    public Cat(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public Cat(String name, int age, String color, int appetite) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.appetite = appetite;
    }

    @Override
    public String toString() {
        String state = wellFed?"сытый":"голодный";
        return "Меня зовут " + name +
                ", мой возраст " + age +
                ", мой цвет " + color +
                ", мой аппетит " + appetite +
                ", сейчас я " + state;
    }

    public void voice() {
        System.out.println("Мяу! "+ this.toString());
    }

    public void eat(Plate plate) { //если голодный, то кушает
        if (!wellFed) {
            this.wellFed = plate.decreaseFood(this.appetite); //котик кушает в соответствии со своим аппетитом
            if (wellFed) {
                System.out.println(this.name + ": Спасибо, я наелся, было вкусно!");
            } else {
                System.out.printf(this.name + ": Я остался голодным! Мне не хватило %d единиц еды\n", (this.appetite - plate.getFood()));
            }
        } else { //если сытый, то не кущает
            System.out.println(this.name + ": Спасибо, я уже сытый!");
        }
    }

}
