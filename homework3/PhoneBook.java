package java2.homework3;

import java.util.Collections;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Pattern;

public class PhoneBook {

    private TreeMap<String, TreeSet<String>> phoneBook = new TreeMap<>();

    private final String PHONE_MATCH_PATTERN = "^\\+\\d{11}$";
    private final String FAMILYNAME_MATCH_PATTERN = "^[a-zA-Zа-яА-Я]+$";

    public void add(String familyName, String phone) {
        TreeSet<String> phones;

        if (!checkValidPhone(phone)) {
            System.out.printf("Номер телефона \"%s\" на соответствует формату \"%s\". ", phone, PHONE_MATCH_PATTERN);
            System.out.println("Запись в телефонную книгу не добавлена");
        } else if (! checkValidFamilyname(familyName)) {
            System.out.printf("Фамилия \"%s\" на соответствует формату \"%s\". ", familyName, FAMILYNAME_MATCH_PATTERN);
            System.out.println("Запись в телефонную книгу не добавлена");
        } else {
            if (phoneBook.containsKey(familyName)) {
                phones = phoneBook.get(familyName); //получаем ссылку
                phones.add(phone);                  //и добавляем по ссылке еще один номер телефона
            } else {        //если такого контакта нет, то добавляем запись
                phones = new TreeSet<>(Collections.singletonList(phone));
                phoneBook.put(familyName, phones);
            }
            System.out.printf("Запись \"%s - %s\" добавлена в телефонную книгу%n", familyName, phone);
        }
    }


    public void get(String familyName) {
        if (phoneBook.containsKey(familyName)) {
            TreeSet<String> phones = phoneBook.get(familyName);
            System.out.printf("Телефоны \"%s\":%n", familyName);
            for (String phone : phones) {
                System.out.println(phone);
            }
        } else {
            System.out.printf("Контакта \"%s\" не найдено в справочнике%n", familyName);
        }
    }

    private boolean checkValidPhone(String phone) {
        return  Pattern.matches(PHONE_MATCH_PATTERN, phone);
    }

    private boolean checkValidFamilyname(String familyName) {
        return  Pattern.matches(FAMILYNAME_MATCH_PATTERN,familyName);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Содержимое телефонной книги:\n");
        int cnt = 0;
        for (String s : phoneBook.keySet()) {
            cnt ++;
            result.append("Телефоны \"").append(s).append("\":\n");
            for (String phone : phoneBook.get(s) ) {
                result.append(phone).append("\n");
            }
        }
        result.append("Количество контактов в телефонной книге ").append(cnt);
        return result.toString();
    }


    public void printAll() {
        System.out.println(toString());
    }

}
