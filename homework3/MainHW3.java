package java2.homework3;

import java.util.*;

public class MainHW3 {
    public static void main(String[] args) {
        System.out.println("Домашняя работа №3. Коллекции.");


        System.out.println("Задание №1:");
        String[] words = {"Ствол", "Бревно", "Полено","Дерево", "Коллекция", "Домашка", "Учеба", "Сессия", "Методичка", "Презентация", "Массив",
                "Ствол", "Бревно", "Полено", "Коллекция",
                "Ствол", "Бревно" };

        printUniqueWords(words); //вывод списка уникальных слов и их количества
        System.out.println("-------------------------------");



        System.out.println("Задание №2:");
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иванов", "+79221025034");
        phoneBook.add("Петров", "+79221025035");
        phoneBook.add("Иванов", "+79221025036");

        phoneBook.add("Васильев", "ыфвфыв");//кривой телефон, запись добавлена не будет
        phoneBook.add("256854", "+79221025037");//кривая фамилия, запись добавлена не будет

        phoneBook.get("Петров");
        phoneBook.get("Иванов");
        phoneBook.get("Васильев"); //такого нет

        phoneBook.printAll(); //печать содержимого адресной книги


    }

    private static void printUniqueWords(String[] words) {
        Set<String> uniqueWords = new TreeSet<>(Arrays.asList(words));

        //Потренируюсь с итератором в явном виде:
        Iterator<String> uniqueWordsIter = uniqueWords.iterator();
        int cntNonUniqueWords;
        String uniqueWord;
        int cntUniqueWords = 0;
        while (uniqueWordsIter.hasNext()) {
            cntNonUniqueWords = 0;
            uniqueWord = uniqueWordsIter.next();
            for (String word : words) {
                if (word.equals(uniqueWord)) cntNonUniqueWords++;
            }
            System.out.printf("%d) Слово \"%s\" встречается %d раз(а)%n", ++cntUniqueWords, uniqueWord, cntNonUniqueWords);
        }
        System.out.println("Количество унимальных слов в массиве: " + cntUniqueWords);
    }
}
