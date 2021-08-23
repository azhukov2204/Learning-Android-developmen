package ru.geekbrains.java1;

import java.util.Random;
import java.util.Scanner;

public class HomeWork4 {
    final private static int MIN_SIZE_MAP=3;    //минимальный размер игрового поля
    final private static int MAX_SIZE_MAP=12;   //максимальный размер игрового поля (это значение можно смело менять)
    final private static int MIN_COORD_VALUE=1; //минимальное значение координаты по x или y
    private static int mapSize=3;               //размер игрового поля (задается при запуске игры)
    private static char[][] map;                //массив - игровое поле
    private static int winSeqlen=3;             //длина последовательности, при достижении которой выигрыш (ниже динамически меняется)
    private static int x;                       //коодрината строки (ход игрока или компьютера)
    private static int y;                       //коодрината столбца (ход игрока или компьютера)
    private static int aiX;                     //для вычисления оптимального хода AI
    private static int aiY;                     //для вычисления оптимального хода AI


    //символы игрового поля:
    final private static char C_DOT='°';
    final  private static char C_CROSS='☓';
    final  private static char C_ZERO='⭕';
    final private static char C_INTERSECTION='⬥';
    final private static char C_SPACE='\t';


    private final static Random random = new Random();
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ticTacToe();
    }

    //сама игра начинается тут?
    public static void ticTacToe() {
        boolean isHuman=true;   //пользователь или компьютер
        initMap();

        while(true) {
            gameTurn(isHuman);  //ход пользователя или игрока
            printMap();
            System.out.printf("Совершен ход: X=%d, Y=%d\n", x,y);
            if (!isGameContinues(isHuman)) break; //если выигрыш или ничья - выход

            isHuman= !isHuman; //смена игрока
        }
    }

    //Инициализация игрового поля:
    private static void initMap() {
        System.out.printf("Привет! Тебя приветствует игра Крестики-Нолики!%nВведи размер игрового поля в диапазоне от %d до %d: ", MIN_SIZE_MAP, MAX_SIZE_MAP);
        mapSize=readIntFromScanner(MIN_SIZE_MAP, MAX_SIZE_MAP);
        System.out.println();
        map = new char[mapSize][mapSize];

        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                map[i][j]=C_DOT;   //заполняем игровое поле точками
            }
        }
        getWinSeqlen();             //в этом методе идет установка длины последовательности, при достижении которой выигрыш

        printMap();                 //вывод игрового поля на экран
    }

    //Установка длины последовательности, при достижении которой выигрыш (немножко хардкода):
    private static void getWinSeqlen() {
        if (mapSize>=3 && mapSize<=5) {
            winSeqlen=3;
        } else if (mapSize>=6 && mapSize<=9) {
            winSeqlen=4;
        } else if (mapSize>=10) {
            winSeqlen=5;
        } else {
            System.out.println("Произошел непредвиденный сбой, mapSize = " + mapSize);
            System.exit(-1);
        }
    }

    //печать игрового поля
    private static void printMap() {
        printHeaderMap();
        printLinesMap();
     }

    //печать заголовка игрового поля:
     private static void printHeaderMap() {
        System.out.printf("%c%c",C_INTERSECTION, C_SPACE);
        for (int i = 0; i < mapSize; i++) {
            System.out.printf("%d%c", i+1, C_SPACE);
        }
        System.out.println();
    }

    //печать строк игорового поля:
    private static void printLinesMap() {
        for (int i = 0; i < mapSize; i++) {
            System.out.printf("%d%c", i+1, C_SPACE);
            for (char c: map[i]) {
                System.out.printf("%c%c", c, C_SPACE);
            }
            System.out.println();
        }
        //System.out.println();
    }

    //ход игрока или компьютера:
    private static void gameTurn(boolean isHuman) {
        if (isHuman) playerTurn();
        else aiTurn();
    }

    //ход игрока:
    private static void playerTurn() {
        do {
            System.out.print("\nХод игрока\nВведите координату строки: ");
            x = readIntFromScanner(MIN_COORD_VALUE, mapSize);
            System.out.print("Введите координату столбца: ");
            y = readIntFromScanner(MIN_COORD_VALUE, mapSize);
        } while (!isValidCell(true)); //проверка, что ячейка не занята
        map[x-1][y-1]=C_CROSS;
    }

    //ход компьютера:
    private static void aiTurn() {
        System.out.println("\nХод компьютера:");
        do {
            if (isWinExist(false)) {  //есть ли выигрышный ход для компьютера. Если есть - то занимаем эту клетку
                x=aiX;
                y=aiY;
            } else if (isWinExist(true))  {  //есть ли выигрышный ход для пользователя. Если есть, то занимаем эту клетку (блокировка хода пользователя)
                x=aiX;
                y=aiY;
            } else {  //в остальных случаях рандом
                x = getRandom(MIN_COORD_VALUE, mapSize);
                y = getRandom(MIN_COORD_VALUE, mapSize);
            }
        } while (!isValidCell(false)); //проверка, что ячейка не занята
        map[x-1][y-1]=C_ZERO;
    }


    //Проверка наличия выигрышных клеток (если сходить в эту клетку, то выигрыш):
    private static boolean isWinExist(boolean isHuman) {
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                if ((map[i][j]==C_DOT)  && (isWin(i+1, j+1, isHuman))) {
                    aiX=i+1;
                    aiY=j+1;
                    return true;
                }
            }
        }
        return false;
    }

    //Проверка, является ли ячейка выигрышной:
    private static boolean isWin(int potentialX, int potentialY, boolean isHuman) {
        char winChar;
        if (isHuman) winChar=C_CROSS;
        else winChar=C_ZERO;

        return (verticalWinChain(potentialX, potentialY, winChar) >= winSeqlen) ||
                (horizontalWinChains(potentialX, potentialY, winChar) >= winSeqlen) ||
                (diagonalWinChainRight(potentialX, potentialY, winChar) >= winSeqlen) ||
                (diagonalWinChainLeft(potentialX, potentialY, winChar) >= winSeqlen);

    }

    //Проверка выигрышной комбинации по вертикали:
    private static int verticalWinChain(int potentialX, int potentialY, char winChar) {
        int winChain=1;
        //проверка по вертикали вверх
        for (int i = potentialX-2; i >= 0; i--) {
            if (map[i][potentialY-1]==winChar) winChain++;
            else break;
        }
        //проверка по вертикали вниз
        for (int i = potentialX; i <mapSize ; i++) {
            if (map[i][potentialY-1]==winChar) winChain++;
            else break;
        }
        return winChain;
    }

    //Проверка выигрышной комбинации по горизонтали:
    private static int horizontalWinChains(int potentialX, int potentialY, char winChar) {
        int winChain=1;
        //проверка по горизонтали влево
        for (int i = potentialY-2; i >=0 ; i--) {
            if (map[potentialX-1][i]==winChar) winChain++;
            else break;
        }
        //проверка по горизонтали вправо
        for (int i = potentialY; i <mapSize ; i++) {
            if (map[potentialX-1][i]==winChar) winChain++;
            else break;
        }
        return winChain;
    }

    //Проверка выигрышной комбинации по правой диагонали:
    private static int diagonalWinChainRight(int potentialX, int potentialY, char winChar) {
        int winChain=1;
        //проверка по диагонали вверх
        for (int i = potentialX-2,  j = potentialY; i >=0 && j<mapSize ; i--, j++) {
            if (map[i][j]==winChar) winChain++;
            else break;
        }
        //проверка по диагонили вниз
        for (int i = potentialX,  j = potentialY-2; i <mapSize && j>=0 ; i++, j--) {
            if (map[i][j]==winChar) winChain++;
            else break;
        }

        return winChain;
    }

    //Проверка выигрышной комбинации по левой диагонали:
    private static int diagonalWinChainLeft(int potentialX, int potentialY, char winChar) {
        int winChain=1;
        //проверка по диагонали вверх
        for (int i = potentialX-2,  j = potentialY-2; i >=0 && j>=0 ; i--, j--) {
            if (map[i][j]==winChar) winChain++;
            else break;
        }
        //проверка по диагонили вниз
        for (int i = potentialX,  j = potentialY; i <mapSize && j<mapSize ; i++, j++) {
            if (map[i][j]==winChar) winChain++;
            else break;
        }

        return winChain;
    }


    //Проверка, не занята ли ячейка:
    private static boolean isValidCell(boolean isHuman) {
        if (map[x-1][y-1]==C_DOT) return true;
        else {
            if (isHuman) {System.out.println("Эта ячейка занята!");}
            return false;
        }
    }

    //Проверка на выишрыш или ничью:
    private static boolean isGameContinues(boolean isHuman)
    {
        if (isWin(x,y,isHuman)) {
            System.out.println("Победа "+ (isHuman?"пользователя!":"компьютера!"));
            return false;
        } else if (isDraw()) {
            System.out.println("Ничья!");
            return false;
        }
        return true;
    }

    //Проверка на ничью:
    private static boolean isDraw() {
        for (char[] i: map) {
            for (char j: i) {
                if (j==C_DOT) return false;
            }
        }
        return true;

    }

    public static int readIntFromScanner(int min, int max) {
        int x;
        while(true) {
            while(!scanner.hasNextInt()) {
                System.out.print("Должно быть введено целое число.\nПопробуйте ввести еще раз: ");
                scanner.next();
            }
            x=scanner.nextInt();
            if (x<min || x>max) {
                System.out.printf("Должно быть введено число в пределах от %d до %d.\nПопробуйте ввести еще раз: ", min , max);
            }
            else break;
        }
        return x;
    }
    public static int getRandom(int min, int max) {
        return random.nextInt(max + 1 - min) + min;
    }

}
