package java2.homework2;

public class MainHW2 {
    public static void main(String[] args) {
        System.out.println("Домашнее задание №2");

        //Создаем и заполняем массив:
        String[][] stringArray = new String[4][4];
        int k = 0;
        for (int i = 0; i < stringArray.length; i++) {
            for (int j = 0; j <stringArray[i].length ; j++) {
                stringArray[i][j]=String.valueOf(k);
                k++;
            }
        }

        //stringArray[2][3]="Не число";

        //Вызываем наш метод с обработкой исключений. Исключения checked (от класса Exception), поэтому try/catch тут обязателен
        try {
            System.out.println("Сумма всех элементов массива: " + sumArrayElements(stringArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Что-то пошло не так, рассчет суммы элементов массива выполнить не удалось...");
            e.printStackTrace();
        } finally {
            System.out.println("А этот блок выполняется всегда.");
        }
    }


    //В методе могут возникать исключения. Эти исключения пробрасываются наверх. Оба исключения - checked
    public static int sumArrayElements(String[][] stringArray) throws MyArraySizeException, MyArrayDataException {
        final int RIGHT_ARR_SIZE=4;
        int sumAllElements=0;

        //если размер массива неправильный, кидаем исключение:
        if (!checkArraySize(stringArray, RIGHT_ARR_SIZE)) {
            throw new MyArraySizeException("Размер массива должен быть " + RIGHT_ARR_SIZE + " на " + RIGHT_ARR_SIZE);
        }

        //Суммируем все элементы:
        for (int i = 0; i < stringArray.length; i++) {
            for (int j = 0; j < stringArray[i].length; j++) {
                try {
                    sumAllElements += Integer.parseInt(stringArray[i][j]);
                } catch (Exception e) {
                    //Если преобразовать в int не удалось, то кидаем мсключение:
                    throw new MyArrayDataException("В ячейке " + i + " " + j + " находятся некорректные данные: " + e);
                }
            }
        }
        return sumAllElements;
    }



    private static boolean checkArraySize(String[][] stringArray, int rightArraySize) {
        boolean isRightArraySize = true;

        //Проверим количество строк массива:
        if (stringArray.length != rightArraySize) {
            isRightArraySize = false;
        } else {
            //проверяем размер столбцов:
            for (String[] strings : stringArray) {
                if (strings.length != rightArraySize) {
                    isRightArraySize = false;
                    break;
                }
            }
        }
        return isRightArraySize;
    }

}
