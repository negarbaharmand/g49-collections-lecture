package se.lexicon;

import java.util.HashSet;

public class HashSetDemo {
    public static void main(String[] args) {
        ex2();
    }

    public static void ex1(){
        HashSet<String> countries = new HashSet<>();

        countries.add("Sweden");
        countries.add("Italy");
        countries.add("India");
        countries.add("USA");
        countries.add("Sweden");

        System.out.println(countries);
        System.out.println(countries.size());

    }

    public static void ex2(){

        HashSet<Person> people = new HashSet<>();
        Person person1 = new Person(3, "John", "Doe", "john@test.se");
        Person person2 = new Person(1, "Alice", "Smith", "alice@test.se");
        Person person3 = new Person(2, "Bob", "Johansson", "bob@test.se");
        Person person4 = new Person(2, "Bob", "Johansson", "bob@test.se");

        people.add(person1);
        people.add(person2);
        people.add(person3);
        people.add(person4);
        System.out.println(people.size()); //3



    }
}
