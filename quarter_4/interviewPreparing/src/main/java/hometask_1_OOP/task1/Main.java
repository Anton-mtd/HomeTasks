package hometask_1_OOP.task1;

public class Main {



    public static void main(String[] args) {
        Person person = new Person.PersonBuilder()
                .firstName("anton")
                .lastName("Skomorokhin")
                .middleName("Yrivich")
                .gender("male")
                .age(32)
                .address("Serova")
                .country("USA")
                .phone("8 111 111 11 11")
                .build();



        System.out.println(person);
    }
}
