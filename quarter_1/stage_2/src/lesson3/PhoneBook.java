package lesson3;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private Map<String, String> phoneBook = new HashMap<>();

    public void add(String name, String number) {
        phoneBook.put(number, name);
    }

    public void get(String name) {
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            if (entry.getValue().equals(name)){
                System.out.println(name + ": " + entry.getKey());
            }
        }
    }
}
