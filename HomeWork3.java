package ru.geekbrains.java1;

import java.util.Random;
import java.util.Scanner;

public class HomeWork3 {

    public static Random random = new Random();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        gameMenu();
    }

    public static void gameMenu() {
        while(true) {
            System.out.print("\nВам предлагается на выбор 2 игры:\n" +
                    "1 - Угадай число\n" +
                    "2 - Угадай слово\n" +
                    "-----------------\n" +
                    "0 - Выход\n\n");

            int choice = readIntFromScanner("Ваш выбор: ", 0, 2);

            switch (choice) {
                case 1:
                    guessTheNumber();
                    break;
                case 2:
                    guessTheWords();
                    break;
                case 0:
                    System.out.println("\nДо свидания!\n");
                    System.exit(0);
                    break; //правда break тут не пригодится :)
                default:
                    System.out.println("Такого варианта не существует.Попробуйте сделать выбор еще раз.");
            }
        }

    }



/*1. Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3 попытки угадать это число.
При каждой попытке компьютер должен сообщить больше ли указанное пользователем число чем загаданное, или меньше.
После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).*/
    public static void guessTheNumber() {
        final int MAX_NUMBER=9;
        final int MIN_NUMBER=0;
        final int ATTEMPTS=3;
        int fails; //количество неправильных ответов
        int x; //число, введенное игроком
        boolean isGame=true;

        while(isGame) {
            fails=0;

            int hiddenNumber = getRandom(MIN_NUMBER, MAX_NUMBER); //загадываем целое число
            System.out.printf("\nЗагадано число в диапазоне от %d до %d.\nПопробуйте его угадать. У вас %d попытки.", MIN_NUMBER, MAX_NUMBER, ATTEMPTS);
            //System.out.println(hiddenNumber); // для отладки


            for (int i = 0; i < ATTEMPTS; i++) {
                System.out.println("\nПопытка №" + (i + 1));
                x = readIntFromScanner("Введите число: ", MIN_NUMBER, MAX_NUMBER);
                if (compareNumbers(x, hiddenNumber)) {
                    break;
                } else fails++;
            }
            if (fails == ATTEMPTS) {
                System.out.println("\nК сожалению вы проиграли...\n");
            } else {
                System.out.println("\nВы победитель!\n");
            }
            isGame= readIntFromScanner("Вы хотите сыграть еще раз?\nВарианты ответа: 0 - нет, 1 - да\nВаш выбор:", 0, 1) == 1;
        }
        System.out.println("До свидания!");

    }

    public static int getRandom(int min, int max) {
        return random.nextInt(max + 1 - min) + min;
    }

    public static int readIntFromScanner(String msg, int min, int max) {
        int x;
        System.out.print(msg);
        while(true) {
            while(!scanner.hasNextInt()) {
                System.out.print("Должно быть введено целое число.\nПопробуйте ввести еще раз: ");
                scanner.nextLine();
            }
            x=scanner.nextInt();
            if (x<min || x>max) {
                System.out.printf("Должно быть введено число в пределах от %d до %d.\nПопробуйте ввести еще раз: ", min , max);
            }
            else break;
        }
        return x;
    }

    public static boolean compareNumbers(int x, int hiddenNumber) {
        boolean result=false;
        if (hiddenNumber == x) {
            System.out.println("Вы угадали!");
            result=true;
        } else {
            System.out.printf("Введенное число %s загаданного\n", (x < hiddenNumber) ? "меньше" : "больше");
        }
        return result;
    }

/*2 * Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
"carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
"pear", "pepper", "pineapple", "pumpkin", "potato"};

При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь. Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.
apple – загаданное
apricot - ответ игрока
ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
Для сравнения двух слов посимвольно, можно пользоваться:
String str = "apple";
str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
Играем до тех пор, пока игрок не отгадает слово
Используем только маленькие буквы*/

    public static void guessTheWords() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
                "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String userWord;
        int hiddenWordNo;
        String hiddenWord;
        final int MAX_HIDDEN_CHARS=15;
        boolean isGame=true;
        boolean wordNotGuessed;
        int attempts;

        while(isGame) {
            attempts = 0;
            wordNotGuessed=true;
            hiddenWordNo = getRandom(0, words.length) - 1; //загадываем слово
            hiddenWord = words[hiddenWordNo];
            //System.out.println(hiddenWord); //для отладки

            System.out.println("\nЗагадано одно из следующих слов: ");
            for (String i : words) {
                System.out.printf("%s ", i);
            }
            System.out.print("\nПопробуйте угадать, какое.\nВведите ваш ответ: ");

            while (wordNotGuessed) {
                attempts++;
                userWord = scanner.next().toLowerCase();

                if (userWord.equals(hiddenWord)) {
                    System.out.printf("Вы угадали слово с %d попытки!\n", attempts);
                    wordNotGuessed = false;
                } else {
                    printMatchingChars(userWord, hiddenWord, MAX_HIDDEN_CHARS);
                    System.out.print("\nПопробуйте угадать слово еще раз: ");
                }
            }
            isGame= readIntFromScanner("\nВы хотите сыграть еще раз?\nВарианты ответа: 0 - нет, 1 - да\nВаш выбор:", 0, 1) == 1;
        }
        System.out.println("\nДо свидания!\n");
    }

    public static void printMatchingChars(String userWord, String hiddenWord, int maxHiddenCharsLength) {
        char[] userChars=userWord.toCharArray();
        char[] hiddenChars=hiddenWord.toCharArray();
        int userCharsLength=userChars.length;
        int hiddenCharsLength =hiddenChars.length;

        System.out.print("Угаданные буквы слова: ");

        int maxCountCharsForPrint =Math.min(userCharsLength, hiddenCharsLength);

        for (int i = 0; i < maxCountCharsForPrint; i++) {
            char charForPrint=(userChars[i]==hiddenChars[i])?hiddenChars[i]:'#';
            System.out.print(charForPrint);
        }

        /*выводим оставшиеся #*/
        if (maxCountCharsForPrint < maxHiddenCharsLength) {
            for (int j = 0; j < (maxHiddenCharsLength - maxCountCharsForPrint); j++) {
                System.out.print("#");
            }
        }
    }

}






