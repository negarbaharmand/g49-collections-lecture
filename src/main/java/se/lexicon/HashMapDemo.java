package se.lexicon;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) {
        ex1();
    }

    private static void ex1() {
        HashMap<String, String> contacts = new HashMap<>();

        contacts.put("Negar", "negar@test.se");
        contacts.put("Mehrdad", "mehrdad@test.se");
        contacts.put("Negar", "negar2@test.se");

        System.out.println(contacts.get("Mehrdad"));
        System.out.println(contacts.get("Negar"));

        System.out.println(contacts.containsKey("Negar"));
        System.out.println(contacts.containsValue("negar@test.se"));

        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }

        System.out.println(contacts.get("Negar")); //Finds the object by its key and prints the value


        //Bonus: An extra example:
        HashMap<String, Person> people = new HashMap<>();
        Person person1 = new Person(3, "John", "Doe", "john@test.se");
        Person person2 = new Person(1, "Alice", "Smith", "alice@test.se");
        Person person3 = new Person(2, "Bob", "Johanson", "bob@test.se");
        people.put(person1.getEmail(), person1);
        people.put(person2.getEmail(), person2);
        people.put(person3.getEmail(), person3);

        System.out.println(people.get("john@test.se"));//prints toString method of Person class
    }

}
