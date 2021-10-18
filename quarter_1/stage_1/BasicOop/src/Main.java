import java.util.Random;

public class Main {

    public static Random random = new Random();

    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Иванов Иван Иванович", "Менеджер", "iv_iv@mail.ru", randomTelNumber(), randomSalary(), randomAge());
        employees[1] = new Employee("Петров Сергей Васильевич", "It специалист", "spec@mail.ru", randomTelNumber(), randomSalary(), randomAge());
        employees[2] = new Employee("Сидорова Ольга Михайловна", "Бугхалтер", "olga_m@mail.ru", randomTelNumber(), randomSalary(), randomAge());
        employees[3] = new Employee("Лопатина Надежда Олеговна", "Инженер", "nad_oleg@yandex.ru", randomTelNumber(), randomSalary(), randomAge());
        employees[4] = new Employee("Трухина Светлана Антоновна", "Секретарь", "svet_truh@gmail.ru", randomTelNumber(), randomSalary(), randomAge());

        for (int i = 0; i < employees.length ; i++) {
            if (employees[i].getAge() > 40){
                employees[i].info();
                System.out.println();
            }
        }
    }

    public static String randomTelNumber(){
        int a;
        String number = "+7 905 ";
        for (int i = 0; i < 7 ; i++) {
            a = random.nextInt(10);
            number = number + a;
            if (i == 2 || i == 4)
                number = number + " ";
        }
        return number;
    }

    public static int randomAge(){
        int minAge = 22;
        int maxAge = 60;
        return minAge + random.nextInt(maxAge - minAge + 1);
    }

    public static int randomSalary(){
        int minSalary = 30000 * 100;
        int salaryStep = 5000 * 100;
        return minSalary + salaryStep * (1 + random.nextInt(11));
    }
}
