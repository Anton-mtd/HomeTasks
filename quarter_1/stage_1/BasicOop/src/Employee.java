public class Employee {
    private String name;
    private String post;
    private String email;
    private String telNumber;
    private int salary;
    private int age;

    public Employee(String name, String post, String email, String telNumber, int salary, int age) {
        this.name = name;
        this.post = post;
        this.email = email;
        this.telNumber = telNumber;
        this.salary = salary;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getPost() {
        return post;
    }

    public String getEmail() {
        return email;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public void info(){
        System.out.println("ФИО: " + getName());
        System.out.println("Должность: " + getPost());
        System.out.println("email: " + getEmail());
        System.out.println("Телефон: " + getTelNumber());
        System.out.println("Зарплата: " + getSalary() / 100 + " руб.");
        System.out.println("Возраст: " + getAge());
    }
}
