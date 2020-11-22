package ru.geekbrains.java1;

public class HomeWork1 {
    //1. Создать пустой проект в IntelliJ IDEA и прописать метод main():
    public static void main(String[] args) {
        double a,b,c,d;
        int a2;

        //Задание 2.
        System.out.println("-------- Задание 2---------------");
        testVariables();

        //Задание 3.
        System.out.println("-------- Задание 3---------------");
        a=1.5; b=2; c=3; d=17;
        System.out.println("Результат "+a+"*("+b+"+("+c+"/"+d+"))  = "+testExpression(a, b, c, d));

        //Задание 4.
        System.out.println("-------- Задание 4---------------");
        a=11.7; b=2.5;
        System.out.println(" 10<=("+a+"+"+b+")<=20  -  "+ testCompare(a,b) );

        System.out.println("-------- Задание 5---------------");
        a2=-11;
        testIsPositive(a2);

        System.out.println("-------- Задание 6---------------");
        a2=-5;
        System.out.println("Число "+a2+" отрицательное? " + testIsNegative(a2));

        System.out.println("-------- Задание 7---------------");
        testPrintName("Андрей");

        System.out.println("-------- Задание 8---------------");
        testIsLeapYear(1500);

    }
    //2.Создать переменные всех пройденных типов данных и инициализировать их значения:
    public static void testVariables() {
        byte varByte=123;
        short varShort=-1212;
        int varInt=-500;
        long varLong=1212121212L;
        float varFloat=32.32f;
        double varDouble=143.25;
        char varChar='K';
        boolean varBoolean=false;
        String varString="Тестовая строка"; //по сути это массив  элементов char
        System.out.println("varByte="+varByte);
        System.out.println("varShort="+varShort);
        System.out.println("varInt="+varInt);
        System.out.println("varLong="+varLong);
        System.out.println("varFloat="+varFloat);
        System.out.println("varDouble="+varDouble);
        System.out.println("varChar="+varChar);
        System.out.println("varBoolean="+varBoolean);
        System.out.println("varString="+varString);
    }

    //3.Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат:
    public static double testExpression(double a, double b, double c, double d) {
        return a*(b+(c/d));
        //проверку на ошибку деления на 0 не вставил, к exception не привело, при делении на 0 возвращается значение Infinity
    }

    /*4.Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит в пределах от 10 до 20(включительно),
     если да – вернуть true, в противном случае – false;*/
    public static boolean testCompare(double a, double b) {
        return (a+b)>=10 && (a+b)<=20;
    }

    /*5. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать
    в консоль положительное ли число передали, или отрицательное; Замечание: ноль считаем положительным числом.*/
    public static void testIsPositive(int a) {
        String positivStr;
        if (a>=0) positivStr=" положительное";
        else positivStr=" отрицательное";
        System.out.println("Число "+ a + positivStr);
    }

    //6. Написать метод, которому в качестве параметра передается целое число, метод должен вернуть true, если число отрицательное
    public static boolean testIsNegative(int a) {
        return a<0;
    }
    /*Написать метод, которому в качестве параметра передается строка, обозначающая имя, метод должен вывести
    в консоль сообщение «Привет, указанное_имя!»*/
    public static void testPrintName(String name) {
        System.out.println("Привет, " + name+"!");
    }

    /*8. * Написать метод, который определяет является ли год високосным, и выводит сообщение в консоль.
    Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.*/

    public static void testIsLeapYear(int year) {
        String particle="";
        /*
        (year%400==0) - 100% високосный год. После проверки на деление на 400 проверяем:
        !(year%100==0) -  "кроме каждого 100-го". И объединяем с условием (year%4==0)
        */
        boolean isLeapYear=(year%400==0)||(!(year%100==0) && (year%4==0));
        if (!isLeapYear) {particle=" не";}
        System.out.println("Год " + year+particle+" является високосным");

        //Изначально был вариант как выше. Ниже все действия в одну строку уложил (в плане визуального восприятия мне больше нравится более подробная конструкция выше).
        System.out.println("Год " + year+(((year%400==0)||(!(year%100==0) && (year%4==0)))?"":" не")+" является високосным");
    }
}
