package java2.homework5;

import java.util.Arrays;

public class MainHW5
{
    static final int size = 10000000;
    static final int h = size / 2;

    static float[] arrForOneThread = new float[size]; //будет использоваться в первом методе (в один поток)
    static float[] arrForTwoThreads = new float[size]; //будет использоваться во втором методе (в два потока)

    public static void main(String[] args) {
        System.out.println("Домашняя работа №5. Потоки");

        calcArrayWithOneThread();
        calcArrayWithTwoThreads();

        checkArrays();
    }



    public static void calcArrayWithOneThread() {
        Arrays.fill(arrForOneThread, 1);         //заполняем массив единицами:

        long startTime = System.currentTimeMillis(); //засекаем время выполнения
        //вычисления по формуле:
        calculate(arrForOneThread, 0);

        long endTime = System.currentTimeMillis(); //засекаем время окончания

        System.out.println("В один поток. Время работы в мс: " + (endTime-startTime));
    }

    public static void calcArrayWithTwoThreads() {
        Arrays.fill(arrForTwoThreads, 1);         //заполняем массив единицами:

        long startTime = System.currentTimeMillis();  //засекаем время выполнения

        //разбиваем массив на два массива (50% на 50% элементов массива)
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        System.arraycopy(arrForTwoThreads,0, a1, 0, h);
        System.arraycopy(arrForTwoThreads, h, a2, 0, h);

        //создаем 2 потока для вычислений:
        Thread firstArrayProcessing =  new Thread (() -> {
            calculate(a1, 0);
            System.out.println("Первый поток. Время работы в мс: " + (System.currentTimeMillis() - startTime));
        });

        Thread secondArrayProcessing = new Thread (() -> {
            calculate(a2, h);
            System.out.println("Второй поток. Время работы в мс: " + (System.currentTimeMillis() - startTime));
        });

        //Запускаем эти 2 потока:
        secondArrayProcessing.start();
        firstArrayProcessing.start();
//заметил, что с увеличением индекса скорость вычислений уменьшается. Второй поток (вторая половина элементов) вычисляется дольше, чем первый

        //Ожидаем выполнения этих потоков:
        try {
            firstArrayProcessing.join();
            secondArrayProcessing.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //склеиваем массивы обратно в один:
        System.arraycopy(a1, 0, arrForTwoThreads, 0, h);
        System.arraycopy(a2, 0, arrForTwoThreads, h, h);

        long endTime = System.currentTimeMillis(); //засекаем время окончания

        System.out.println("В два потока. Время работы в мс: " + (endTime - startTime));

    }

    private static void calculate(float[] arr, int offset) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + (i + offset) / 5) * Math.cos(0.2f + (i + offset) / 5) * Math.cos(0.4f + (i + offset) / 2));
        }
    }

    private static void checkArrays() {
        boolean isCheck=true;
        for (int i = 0; i < size; i++) {
            if (arrForOneThread[i]!= arrForTwoThreads[i]) {
                isCheck = false;
                System.out.println("Внимание, массивы различаются, проверь элементы массивов под номером: " + i);
                break;
            }
        }
        System.out.println("Массивы " + (isCheck?"совпадают!":"не совпадают!"));
    }


}
