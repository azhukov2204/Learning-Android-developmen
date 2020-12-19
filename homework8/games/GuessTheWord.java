package homework8.games;

public class GuessTheWord extends Games {
    public String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
            "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
            "pear", "pepper", "pineapple", "pumpkin", "potato"};
    private String hiddenWord;
    private final int MAX_HIDDEN_CHARS=15;

    @Override
    public String greeting() {
        StringBuilder msg= new StringBuilder("Загадано одно из следующих слов: \n");
        for (String i : words) {
            msg.append(i).append(", ");
        }
        msg.append("\nПопробуйте угадать, какое.");

        return msg.toString();
    }

    @Override
    public void resetGame() {
        super.resetGame();
        hiddenNumber = getRandom(0, words.length - 1); //загадываем слово
        hiddenWord = words[hiddenNumber];
    }

    public GuessTheWord() {
        resetGame();
    }

    //@Override
    public String playerTurn(String userWord) {
        String result;
        if (!isGame()) return "Игра окончена\n"; //первым делом проверим, идет ли вообще игра

        attempts++;
        if (isWin(userWord)) {    //Успех
            result = "Вы угадали слово с " + attempts + " попытки";
        } else {                    //Неудача
            result = printMatchingChars(userWord);
            }

        return result;
    }


    private String printMatchingChars(String userWord) {
        StringBuilder result;
        char[] userChars=userWord.toCharArray();
        char[] hiddenChars=hiddenWord.toCharArray();
        int userCharsLength=userChars.length;
        int hiddenCharsLength =hiddenChars.length;

        result = new StringBuilder("Угаданные буквы слова: ");

        int maxCountCharsForPrint =Math.min(userCharsLength, hiddenCharsLength);

        for (int i = 0; i < maxCountCharsForPrint; i++) {
            char charForPrint=(userChars[i]==hiddenChars[i])?hiddenChars[i]:'#';
            result.append(charForPrint);
        }

        /*выводим оставшиеся #*/
        if (maxCountCharsForPrint < MAX_HIDDEN_CHARS) {
            for (int j = 0; j < (MAX_HIDDEN_CHARS - maxCountCharsForPrint); j++) {
                result.append("#");
            }
        }
        return result.toString();
    }



    private boolean isWin(String userWord) {
        if (userWord.equals(hiddenWord)) {
            isGame = false;
            return true;
        } else return false;
    }




}
