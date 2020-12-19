package homework8.games;

public class GuessTheNumber extends Games {

    private  int maxNumber =9;
    private  int minNumber =0;
    private  int maxAttempts =3;


    //Сделаю сеттеры, елси вдруг надумаю менять эти лимиты
    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    public void setMinNumber(int minNumber) {
        this.minNumber = minNumber;
    }

    public void setMaxAttempts(int maxAttempts) {
        this.maxAttempts = maxAttempts;
    }

    @Override
    public void resetGame() {
        super.resetGame();
        hiddenNumber = getRandom(minNumber, maxNumber); //загадываем целое число
    }

    public GuessTheNumber() {
        resetGame();
    }

    @Override
    public String greeting() {
        return  "Загадано число в диапазоне от " + minNumber + " до " + maxNumber + ". Попробуй отгадать с " + maxAttempts + " попыток";
    }

    //@Override
    public String playerTurn(String userWord) { //сделал String, чтоб можно было полиморфизмом воспользоваться без дополнительного приведения типа
        int x = 0;
        try {
            x = Integer.parseInt(userWord);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        String result;

        if (!isGame()) return "Игра окончена\n"; //первым делом проверим, идет ли вообще игра

        if (x < minNumber || x > maxNumber) {  //Выход за границы диапазона не будем считать попыткой
            result = "Должно быть введено число в пределах от " + minNumber + " до " + maxNumber + ". Попробуйте ввести еще раз\n";
        } else {
            attempts++;
            if (isWin(x)) {    //Успех
                result = "Вы угадали число с " + attempts + " попытки";

            } else {                    //Неудача
                result = "Введенное число " + ((x < hiddenNumber) ? "меньше" : "больше") + "загаданного. \n";
                if (isLose()) result+="К сожалению вы проиграли. Было загадано число " + hiddenNumber;
            }
        }
        return result;
    }

    private boolean isWin(int x) {
        if (hiddenNumber == x) {
            isGame = false;
            return true;
        } else return false;
    }

    private boolean isLose() {
        if (attempts>= maxAttempts) {
            isGame = false;
            return true;
        } else return false;
    }


}
