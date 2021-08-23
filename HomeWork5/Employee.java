package HomeWork5;

public class Employee {
    private static int employeeCount=0; //подсмотрено на уроке. при вызове конструктора будет ++
    private  String fullName;
    private  String position;
    private  String email;
    private  String phone;
    private  int salary; //зарплата будет в целых числах
    private  int age;

    public Employee(String fullName, String position, String email, String phone, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
        employeeCount++; //увеличение количества сотрудников
    }

    @Override
    public String toString() {
        return "Информация о сотруднике: " +
                "Имя: '" + fullName + '\'' +
                ", должность: '" + position + '\'' +
                ", email: '" + email + '\'' +
                ", телефон: " + phone +
                ", зарплата: '" + salary +
                ", возраст: " + age ;
    }
    public void printInfo() {

        System.out.println(this);
    }

    public int getAge() {

        return age;
    }

    public static int getEmployeeCount() {
        return employeeCount;
    }
}
