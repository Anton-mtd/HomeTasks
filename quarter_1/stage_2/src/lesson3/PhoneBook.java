package lesson3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneBook {
    private Map<String, Set<String>> phoneBook = new HashMap<>();

    public void add(String name, String number) {
        if (phoneBook.containsKey(name)) {
            phoneBook.get(name).add(number);
        } else {Set<String> setNumbers = new HashSet<>();
            setNumbers.add(number);
            phoneBook.put(name, setNumbers);}
    }

    public void get(String name) {
        for (String number : phoneBook.get(name)) {
            System.out.println(name + ": " + number);
        }
    }
}
