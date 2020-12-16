package homework7;

public class Plate {
    private int food;

    public Plate() {
        this.food=0;
    }

    public Plate(int food) {
        if (food<0) {
            this.food=0;
            System.out.println("Указано отрицательное значение! Миска пустая.");
        } else this.food = food;
    }

    public int getFood() {
        return food;
    }

    //метод, с помощью которого добавляем еду в миску:
    public void increaseFood(int n) {
        this.food+=n;
    }

    //"сделать так, чтобы не могло получиться отрицательного количества еды":
    public boolean decreaseFood(int n) {
        if (this.food>=n) {
            this.food-=n;
            return true;    //если удалось поесть - результат true.
        }
        else {
            return false;   //если не удалось - результат false  (если еды мало, то ее не трогаем)
        }
    }

    @Override
    public String toString() {
        return "В миске " + this.food + " единиц еды";
    }

    public void info() {
        System.out.println(this.toString());
    }
}
