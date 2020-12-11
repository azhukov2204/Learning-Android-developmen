package HomeWork5;

public class Main {
    public static void main(String[] args) {
        final int MAX_AGE=40;

        System.out.println("Домашнее задание №5");

        Employee[] workers = new Employee[5];

        workers[0]= new Employee("Иван Иваныч", "Дворник", "ivanov@mywork.com", "8-123-42-45-121", 15, 30);
        workers[1]= new Employee("Петр Петрович", "Сантехник", "pterov@mywork.com", "8-123-42-45-122", 20, 15);
        workers[2]= new Employee("Федор Михайлович", "Инженер", "feodor@mywork.com", "8-123-42-45-123", 35, 50);
        workers[3]= new Employee("Михаил Алексееч", "Механик", "mikhaa@mywork.com", "8-123-42-45-124", 40, 24);
        workers[4]= new Employee("Михаил Юрьевич", "Директор", "mikhay@mywork.com", "8-123-42-45-125", 300, 45);

        Employee aloneWorker = new Employee("Антон Павлович", "Телефонист", "anton@mywork.com", "8-132-123-45-12", 40, 35);

        System.out.printf("Вывод информации о сотрудниказ, возраст которых выше %d лет:%n", MAX_AGE);
        for (Employee person : workers) {
            if (person.getAge()>MAX_AGE) {
                person.printInfo();
            }
        }
        System.out.printf("Всего в организации %d сотрудников, а в массиве %d\n", Employee.getEmployeeCount(), workers.length);
        //System.out.println(aloneWorker); //тест, как отработает toString
    }
}
