package ru.geekbrains.java1;

import java.util.Arrays;

public class HomeWork2 {
    public static void main(String[] args) {
        System.out.println("-------Задание 1--------");
        invertArray();

        System.out.println("-------Задание 2--------");
        fillArray();

        System.out.println("-------Задание 3--------");
        chArray();

        System.out.println("-------Задание 4--------");
        squareArray(9);

        System.out.println("-------Задание 5--------");
        int[] a = {-50 ,-5,-6,100,102,-250};
        System.out.println("Исходный массив: " + Arrays.toString(a));
        System.out.println("Максимальный элемент: " + maxElement(a));
        System.out.println("Минимальный элемент: " + minElement(a));


        System.out.println("-------Задание 6--------");
        int[] b = {1, 1, 1,6,  2, 0, 3,4};
        System.out.println("Массив "+ Arrays.toString(b));
        System.out.println("Есть ли место, в котором сумма левой и правой части массива равны?  - " + checkBalance(b));

        System.out.println("-------Задание 7--------");
        int[] c = {1,2,3,4,5,6,7};
        System.out.println("Исходный массив: " + Arrays.toString(c));
        int offset=3;
        shiftArray(c, offset); //смещаем массив (передаем указалель)
        System.out.println("Смещенный массив: " + Arrays.toString(c) + ". Смещение (от предыдущего состояния): "+ offset);
        offset=-4;
        shiftArray(c, offset); //смещаем массив (передаем указалель)
        System.out.println("Смещенный массив: " + Arrays.toString(c) + ". Смещение (от предыдущего состояния): "+ offset);
        offset=-1;
        shiftArray(c, offset); //смещаем массив (передаем указалель)
        System.out.println("Смещенный массив: " + Arrays.toString(c) + ". Смещение (от предыдущего состояния): "+ offset);

        System.out.println("-------Задание 8--------");
        int[][] spiralArray = spiralArray(9);
        //выводим матрицу на экран:
        print2DArray(spiralArray);


    }

    /*1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
    С помощью цикла и условия заменить 0 на 1, 1 на 0;*/
    public static void invertArray() {
        int[] a = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
        System.out.println("Исходный массив:        " + Arrays.toString(a));
        for(int i=0; i<a.length; i++) {
            a[i]=(a[i]==1)?0:1; //делаем инверсию
        }
        System.out.println("Инвертированный массив: " + Arrays.toString(a));
    }
    /*2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;*/
    public static void fillArray() {
        final int ARR_SIZE =8; //размер массива
        final int FACTOR=3; //множитель

        int[] a = new int[ARR_SIZE]; //создаем массим
        for (int i = 0; i< ARR_SIZE; i++) {
            a[i]=i*FACTOR;
        }
        System.out.println("Полученный массив: "+ Arrays.toString(a));
    }

    /*3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;*/
    public static void chArray() {
        int[] a = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        final int COMPARE_NUMBER=6; //будем сравнивать с этим числом
        final int FACTOR=2; //множитель

        System.out.println("Исходный массив:         " + Arrays.toString(a));
        for (int i = 0; i < a.length; i++) {
            a[i]=(a[i]<COMPARE_NUMBER)?a[i]*FACTOR:a[i];
        }
        System.out.println("Модифицированный массив: " + Arrays.toString(a));
    }

    /*4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    и с помощью цикла(-ов) заполнить его диагональные элементы единицами;*/
    public static void squareArray(int arraySize) {
        int[][] a = new int[arraySize][arraySize];
        for (int i = 0; i < arraySize; i++) {
            for (int j = 0; j < arraySize; j++) {
                a[i][j]=((i==j)||(i+j==arraySize-1))?1:0; //нарисовав на бумажке сразу увидел закономерность вычисления индексов диагоналей :)
            }
        }
        //выводим матрицу на экран:
        print2DArray(a);
    }

    //для вывода 2D матриц
    public static void print2DArray(int[][] a) {
        for (int[] i: a) {
            for (int j: i)  System.out.printf("%3d\t", j);
            System.out.println();
        }
    }

    /*5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);*/
    public static int maxElement(int[] a) {
        int m=a[0]; //для поимка максимума
        for (int i = 1; i < a.length; i++) {
            m= (a[i]>m)?a[i]:m;
        }
        //System.out.println("Максимальный элемент = " + m);
        return m;
    }

    public static int minElement(int[] a) {
        int m=a[0]; //для поимка минимума
        for (int i = 1; i < a.length; i++) {
            m= (a[i]<m)?a[i]:m;
        }
        //System.out.println("Минимальный элемент = " + m);
        return m;
    }


    /*6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
    если в массиве есть место, в котором сумма левой и правой части массива равны.
    Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
    граница показана символами ||, эти символы в массив не входят.*/
    public static boolean checkBalance(int[] a) {
        int summAllElements=0;
        int summFirstElements=0;
        boolean result = false;
        for (int i: a) {summAllElements+=i;} //сначала посчитаем сумму всех элементов массива
        for (int j : a) {
            summFirstElements += j;
            if (summFirstElements * 2 == summAllElements) { //т.к. ищем половину по сумме элементов, то для сравнения умножаем на 2
                result= true;
                break;
            }
        }
        return result;
    }

    /*7. **** Написать метод, которому на вход подается одномерный массив и число n
    (может быть положительным, или отрицательным), при этом метод должен сместить все элементымассива на n позиций.
    Для усложнения задачи нельзя пользоваться вспомогательными массивами.*/
    public static void shiftArray(int[] a, int n) {
        //System.out.println("Исходный массив: " + Arrays.toString(a) + ", n = " + n);
        int oneElement;
        int arraySize=a.length;

        if (n>=0) { //смещение в одну сторону
            for (int j = 0; j < n; j++) {
                oneElement = a[0];
                for (int i = 0; i < arraySize - 1; i++) a[i] = a[i + 1];
                a[arraySize - 1] = oneElement;
            }
        } else { //смещение в другую сторону
            for (int j = 0; j > n; j--) {
                oneElement = a[arraySize - 1];
                for (int i = 0; i < arraySize - 1; i++) a[arraySize - 1 - i] = a[arraySize - 2 - i];
                a[0] = oneElement;
            }
        }
        //System.out.println("Смещенный массив: " + Arrays.toString(a));
    }

    /*Бонусное задание: Спиралька*/
    public static int[][] spiralArray(int arraySize) {
        int[][] a = new int[arraySize][arraySize];
        int elementNumbers = arraySize*arraySize;
        int x=0;
        int y=0;
        int currVal=0;//текущее значение нового элемента
        int step=0;

        //поводил карандашом по клеткам и соорудил вот такой алгоритм :)
        for (int i = 0; i < elementNumbers; i++) {
            a[x][y]=currVal++;
            if ( (x<arraySize-1-step) && (y==0+step) ) {x++;}
            else if (  (x==arraySize-1-step) && (y<arraySize-1-step) ) {y++;}
            else if (  (y==arraySize-1-step) && (x>0+step) ) {x--;}
            else if (  (x==0+step) && (y>1+step)  ) {y--;}
            else if (  (x==0+step) && (y==1+step)  ) {
                step++; //сужаем квадрат
                x++;
            }
        }
        return a;
    }
}

