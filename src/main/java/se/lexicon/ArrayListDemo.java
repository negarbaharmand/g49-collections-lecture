package se.lexicon;

import java.util.*;

public class ArrayListDemo {

    public static void main(String[] args) {
        ex2();
    }

    public static void ex1() {
        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(100);
        numbers.add(200);
        numbers.add(100);
        numbers.add(400);
        numbers.add(200);
        numbers.add(300);

        System.out.println(numbers); //[100, 200, 100, 400, 200]
        System.out.println(numbers.size()); //5

        System.out.println("accessing element of index 0: " + numbers.get(0));
        System.out.println("accessing element of index 1: " + numbers.get(1));
        System.out.println("accessing element of index 2: " + numbers.get(2));



        /*Iterator<Integer> numbersIterator = numbers.iterator();
        while (numbersIterator.hasNext()){
            Integer number = numbersIterator.next();
            System.out.println(number);}*/

        for (Integer number : numbers) { //[100, 200, 100, 400, 200]

            System.out.println("number = " + number); // 100
            // if (number == 100) numbers.remove(number); //throws ConcurrentModification error
        }


    }

    public static void ex2() {
        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(100);
        numbers.add(200);
        numbers.add(100);
        numbers.add(400);
        numbers.add(200);
        System.out.println(numbers.size());

        boolean isRemoved = numbers.remove(Integer.valueOf(100)); //Integer object
        // numbers.remove(new Integer(100));
        System.out.println("Result: " + isRemoved);
        System.out.println(numbers.size()); //4

        Integer resultToRemoveIndex0 = numbers.remove(0);
        System.out.println(resultToRemoveIndex0);

        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }

    }

    public static void ex3() {
        List<String> euCars = new ArrayList<>();
        euCars.add("Volvo");
        euCars.add("VW");
        euCars.add("Volvo");

        List<String> usaCars = new ArrayList<>();
        usaCars.add("Tesla");

        //euCars.addAll(usaCars);

        euCars.addAll(1, usaCars);


        for (String car : euCars) {
            System.out.println(car);
        }

        System.out.println(euCars.lastIndexOf("Volvo")); //3
        euCars.add("Volvo");
        System.out.println(euCars.lastIndexOf("Volvo")); //4

        System.out.println(euCars.indexOf("VW"));

    }

    public static void ex4() {
        ArrayList<String> originalList = new ArrayList<>();
        originalList.add("D");
        originalList.add("B");
        originalList.add("A");
        originalList.add("C");
        originalList.add("a");

        ArrayList<String> referenceToOriginalList = originalList;
        //originalList.remove(0);

        System.out.println("originalList size = " + originalList.size()); //4
        System.out.println("referenceToOriginalList size = " + referenceToOriginalList.size()); //4

        ArrayList<String> cloneList = (ArrayList<String>) originalList.clone();
        originalList.remove(0);
        System.out.println("originalList size = " + originalList.size()); //4
        System.out.println("cloneList size = " + cloneList.size()); //5
    }

    public static void ex5() {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(2);
        numbers.add(8);
        numbers.add(2);
        numbers.add(3);

        numbers.sort(null);
        System.out.println(numbers);

        numbers.sort(Collections.reverseOrder());
        System.out.println(numbers);

        ArrayList<String> letters = new ArrayList<>();
        letters.add("D");
        letters.add("B");
        letters.add("A");
        letters.add("C");
        letters.add("a");
        Collections.sort(letters); //[A,B,C,D,a]
        System.out.println(letters);
        Collections.sort(letters, String.CASE_INSENSITIVE_ORDER);//[A,a,B,C,D]
        System.out.println(letters);

    }

    public static void ex6() {
        String test1 = "TEST";
        String test2 = "TEST";

        boolean isComparedTwoStrings = test1.equals(test2);
        System.out.println("isComparedTwoStrings = " + isComparedTwoStrings); //true
        //Equals method in String class compares two objects in terms of their content
        System.out.println(test1.hashCode()); //2571410
        System.out.println(test2.hashCode()); //2571410

        Person person1 = new Person(1, "Test", "Testsson", "test@test.se");
        Person person2 = new Person(1, "Test", "Testsson", "test@test.se");
        System.out.println(person1.equals(person2)); //true
        System.out.println(person1.hashCode());
        System.out.println(person2.hashCode());


    }

    public static void ex7() {
        ArrayList<Person> people = new ArrayList<>();

        Person person1 = new Person(3, "John", "Doe", "john@test.se");
        Person person2 = new Person(1, "Alice", "Smith", "alice@test.se");
        Person person3 = new Person(2, "Bob", "Johansson", "bob@test.se");

        people.add(person1);
        people.add(person2);
        people.add(person3);
        System.out.println(people.size());//3
        System.out.println(person1.toString());
        System.out.println(person2.toString());
        System.out.println(person3.toString());

        System.out.println(person1); //It refers to toString method

        System.out.println("Original List");
        for (Person person : people) {
            System.out.println(person);
        }

        Collections.sort(people);

        System.out.println("Original List");
        for (Person person : people) {
            System.out.println(person);
        }

        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getFirstName().compareTo(o2.getFirstName());
            }
        });

        System.out.println("Sorted List By implementing a logic(firstName");
        for (Person person : people) {
            System.out.println(person);
        }
        // new: lambda expression
        Collections.sort(people, (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName()));

        // new: method reference
        Collections.sort(people, Comparator.comparing(Person::getFirstName));


    }
}
