package com.org.stream.question;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Person {
    String firstName;
    String lastName;
    int age;
    List<String> color;

    public Person(String firstName, String lastName, int age, List<String> color) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.color = color;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getAge() {
        return this.age;
    }

    public List<String> getColor() {
        return this.color;
    }

    public String toString() {
        return ("FirstName :: " + this.firstName +
                " LastName :: " + this.lastName +
                " Age :: " + this.age +
                " Color :: " + this.color);
    }
}

class Product {
    Long id;
    String name;
    double price;
    String category;

    public Product(Long id, String name, double price, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return this.category;
    }

    @Override
    public String toString() {
        return ("id :: " + this.id +
                " Name ::" + this.name +
                " Price :: " + this.price +
                " Category :: " + this.category
        );
    }
}

class Employee {
    String name;
    int age;
    double salary;
    String gender;

    public Employee(String name, int age, String gender, double salary) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", salary='" + salary + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
class EmployeeDTO {
    String empName;
    int empAge;
    double empSalary;
    String empGender;

    public EmployeeDTO(String empName, int empAge, double empSalary, String empGender) {
        this.empName = empName;
        this.empAge = empAge;
        this.empSalary = empSalary;
        this.empGender = empGender;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getEmpAge() {
        return empAge;
    }

    public void setEmpAge(int empAge) {
        this.empAge = empAge;
    }

    public double getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(double empSalary) {
        this.empSalary = empSalary;
    }

    public String getEmpGender() {
        return empGender;
    }

    public void setEmpGender(String empGender) {
        this.empGender = empGender;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "empName='" + empName + '\'' +
                ", empAge=" + empAge +
                ", empSalary=" + empSalary +
                ", empGender='" + empGender + '\'' +
                '}';
    }
}

public class StringQuestions {
    public static List<Product> getListOfProducts() {
        Product p1 = new Product(111L, "Mobile", 10000.00, "Electronics");
        Product p2 = new Product(121L, "Laptop", 100000.00, "Electronics");
        Product p3 = new Product(222L, "Apple", 200.00, "Fruits");
        Product p4 = new Product(111L, "Shine", 100000.00, "Bike");
        List<Product> products = new ArrayList<>();
        products.add(p1);
        products.add(p2);
        products.add(p4);
        products.add(p3);
        return products;
    }

    public static void main(String[] args) {

        // occurrenceOfEachWord();
        // find2ndHighest();
        // findWordsWithRespectToVowel();
        // findFirstRepeatedCharacterWithStream();
        // findFirstNonRepeatedCharacterWithStream();
        // arrangeListOfStringInAscendingOrder();
        // arrangeListOfStringInAscendingOrderWithAlphabeticalOrder();
        // groupStringBasedOnMiddleCharacter();
        // sortListOfStringInAlphabeticalOrder();
        // convertListOfStringIntoItsLength();
        // removeAllNumericCharacter();
        // containingDigits();
        // convertStringToUpperCase();
        // domainNamewithFreq();
        // groupByFirstCharacterAndCountTheFreq();
        // convertListToMap();
        // uppercaseAndCombineString();
        // mapAndFlatMap();
        // concatenateTwoStream();
//         personNameUniqueAndSorted();
        // productFunctionalities();
//        findNameStartWithAAndCountIt();
//        departmentHasMaximumEmp();
//        employeeOperation();
//        middleCharacter();
//        countSubstring();
//        extractMessage();
//        maxCharFrequencyInString();
//        mapStringWithTheirLength();
        convertEmployeeObjToEmployeeDTO();
    }

    // Given a list of string, return a map of the String and its length
    public static void mapStringWithTheirLength(){
        List<String> fruits = Arrays.asList("orange", "banana", "kiwi", "kiwi");

        Map<String, Integer> fruitsMap = fruits.stream()
                .collect(Collectors.toMap(
                        fruit -> fruit,
                        String::length,
                        (existing, duplicate) -> existing // resolving duplicate key
                        ));
        System.out.println(fruitsMap);
    }

    // Given the String return the character with the maximum frequency in the string.
    private static void maxCharFrequencyInString() {
        String s = "java developer";
        Map<Character, Long> freqMap = s.chars()// it's return integer
                .mapToObj(c -> (char) c) // Now we have to convert c -> Character
                .collect(Collectors.groupingBy(
                        ch -> ch,
                        Collectors.counting()
                ));
        System.out.println(freqMap);
        Optional<Map.Entry<Character, Long>> maxFreqCharacter = freqMap.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue());
        System.out.println(maxFreqCharacter);
        maxFreqCharacter.ifPresent(e -> System.out.println(e.getKey() + " " + e.getValue()));

        Optional<Character> character = freqMap.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
        character.ifPresent(System.out::println);
    }

    /// Transform Employee object into EmployeeDTO
    public static void convertEmployeeObjToEmployeeDTO(){

        List<Employee> employeeList = Arrays.asList(
                new Employee("Anuj", 30, "Male", 8500),
                new Employee("Ramanuj", 30, "Male", 8500),
                new Employee("Kaju", 27, "Female", 8900),
                new Employee("Katli", 28, "Female", 7000)
        );

        List<EmployeeDTO> employeeDTOS = employeeList.stream()
                .map(employee -> {
                    String name = employee.getName();
                    int age = employee.getAge();
                    String gender = employee.getGender();
                    double salary = employee.getSalary();
                    return new EmployeeDTO(name, age, salary, gender);
                })
                .toList();
        System.out.println(employeeDTOS);


    }

    ///  New Concept
    /// Using Stream API extract messages in the correct chronological order form the given log data in format "HH:MM:ID:Message"
    ///
    public static void extractMessage() {
        List<String> logs = Arrays.asList(
                "14:30:3:Server Started",
                "14:30:1:User logged in",
                "14:29:2:Database connected",
                "18:32:4:User logged out"
        );
        /// Output Print messages according to the time If time is same then compare with their ID
        List<String> logsWithRespectToTime = logs.stream()
                .sorted((log1, log2) -> {
                    String[] part1 = log1.split(":");
                    String[] part2 = log2.split(":");
                    int hour1 = Integer.parseInt(part1[0]);
                    int minutes1 = Integer.parseInt(part1[1]);
                    int id1 = Integer.parseInt(part1[2]);

                    int hour2 = Integer.parseInt(part1[0]);
                    int minutes2 = Integer.parseInt(part1[1]);
                    int id2 = Integer.parseInt(part1[2]);

                    if (hour1 != hour2)
                        return Integer.compare(hour1, hour2);

                    if (minutes1 != minutes2)
                        return Integer.compare(minutes1, minutes2);
                    return Integer.compare(id1, id2);
                })
                .map(log -> log.split(":", 4)[3])
                .collect(Collectors.toList());
        System.out.println(logsWithRespectToTime);

        List<String> logsWithRespectToTime2 = logs.stream().sorted(Comparator
                        .comparing((String log) -> log.split(":")[0])
                        .thenComparing(log -> log.split(":")[1])
                        .thenComparing(log -> Integer.parseInt(log.split(":")[2]))
                ).map(log -> log.split(":", 4)[3])
                .collect(Collectors.toList());
        System.out.println(logsWithRespectToTime2);

    }

    // Find the count of the substring that are present inside the string
    public static void countSubstring() {
        String s = "byebyeBirdiebye";
        String pattern = "bye";
        long count = IntStream.range(0, s.length() - (pattern.length() - 1))
                .filter(i -> s.substring(i, i + pattern.length()).equals(pattern))
                .count();
        System.out.println(count);
    }

    // Print the middle character of the given string
    private static void middleCharacter() {
        String s = "Ramanujm";
        String ch = IntStream.range(0, s.length())
                .filter(i -> i == s.length() / 2)
                .mapToObj(i -> String.valueOf(s.charAt(i)))
                .findFirst().orElse("");
        System.out.println(ch);
    }

    // Given a list of employees with their names and department names, write a Stream API solution to find the department that has the maximum number of employees.
    public static void departmentHasMaximumEmp() {
        List<EmployeeV1> employeeV1s = Arrays.asList(
                new EmployeeV1("Rama", 30, "IT", 85000),
                new EmployeeV1("Ramanuj", 29, "IT", 85000),
                new EmployeeV1("Raman", 26, "HR", 8000),
                new EmployeeV1("Aman", 29, "security", 5000),
                new EmployeeV1("manan", 30, "health", 50000)
        );

        Map<String, Long> map = employeeV1s.stream()
                .collect(Collectors.groupingBy(
                        EmployeeV1::getDepartment,
                        Collectors.counting()
                ));
//        Long maxVal = 0L;
//        String dept = "";
//        for (Map.Entry<String, Long> e: map.entrySet()){
//            if(e.getValue()>maxVal){
//                maxVal = e.getValue();
//                dept = e.getKey();
//            }
//        }
        Optional<Map.Entry<String, Long>> deptHasMaxEmp = map.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue());
        deptHasMaxEmp.ifPresent(e -> System.out.println(e.getKey() + " department" + " has maximum " + e.getValue() + " employees"));

        // Calculate the average salary of each department
        Map<String, Double> deptHasAvgSalary = employeeV1s.stream()
                .collect(Collectors.groupingBy(
                        EmployeeV1::getDepartment,
                        Collectors.averagingDouble(EmployeeV1::getSalary)
                ));
        deptHasAvgSalary.forEach((dept, salary) -> System.out.println(dept + " " + salary));
    }

    // Given an Employee object, Run following operation
    public static void employeeOperation() {
        List<Employee> employeeList = Arrays.asList(
                new Employee("Anuj", 30, "Male", 8500),
                new Employee("Ramanuj", 30, "Male", 8500),
                new Employee("Kaju", 27, "Female", 8900),
                new Employee("Katli", 28, "Female", 7000)
        );
        // 1. find Average age of Male/Female employee
        Map<String, Double> averageAge = employeeList.stream()
                .collect(Collectors.groupingBy(
                        employee -> employee.getGender(),
                        Collectors.averagingInt(employee -> employee.getAge())
                ));
        System.out.println(averageAge);

        // 2. Find Average Salary of Male/Female employee
        Map<String, Double> averageSalary = employeeList.stream()
                .collect(Collectors.groupingBy(
                        Employee::getGender,
                        Collectors.averagingDouble(Employee::getSalary)
                ));
        System.out.println(averageSalary);
        System.out.println(employeeList);
        // 3. Find the Employees with salary greater than 2000 and increase their salary by 1000
        List<Employee> increasedSalary = employeeList.stream()
                .filter(employee -> employee.getSalary() > 2000)
                .map(employee -> {
                    double oldSalary = employee.getSalary();
                    double newSalary = oldSalary + 1000;
                    employee.setSalary(newSalary);
                    return employee;
                }).toList();
        System.out.println(increasedSalary);
    }

    // given a list of names, find all the names that start with 'A', and also print the count of names found.
    private static void findNameStartWithAAndCountIt() {
        List<String> names = Arrays.asList("Anuj", "Ankit", "Anup", "Jayant", "Kaju");
        List<String> nameStartWithA = names.stream()
                .filter(name -> name.startsWith("A"))
                .toList();
        System.out.println(nameStartWithA);
        Long countName = nameStartWithA.stream().count();
        System.out.println(countName);
    }

    // Implement the following functionalities of product
    public static void productFunctionalities() {
        // 1. Print the names of products whose price is blow a certain threshold (e.g. 1000)
        List<Product> productslist = getListOfProducts();
        List<String> productsListBelowPrice1000 = productslist.stream()
                .filter(p -> p.getPrice() < 1000)
                .map(Product::getName)
                .toList();
        // System.out.println(productsListBelowPrice1000);

        // 2. Create a new list containing products with a price reduction of 20%
        List<Product> discountedPriceProduct = productslist.stream()
                .map(p -> {
                    double discountedPrice = p.getPrice() - (p.getPrice() * 20) / 100;
                    p.setPrice(discountedPrice);
                    return p;
                }).toList();

        // System.out.println(discountedPriceProduct);

        // 3. Calculate the average price of all products.
        // Map<String, List<Product>> map = productslist.stream()
        // .collect(Collectors.groupingBy(
        //     product -> product.getCategory()
        // ))
        // .entrySet()
        // .stream()
        // .map(Map.Entry::getPrice);
        // System.out.println(map);

        Double averagePrice = productslist.stream().mapToDouble(Product::getPrice).average().getAsDouble();
        // System.out.println(averagePrice);
        // 4. Find the product with the lowest price using Stream API
        Optional<Product> lowestPriceProduct = productslist.stream()
                .min((x1, x2) -> Double.compare(x1.getPrice(), x2.getPrice()));
        if (lowestPriceProduct.isPresent()) System.out.println(lowestPriceProduct.get());
    }

    // Given a Person list, fetch the list of names of a Person
    // - Whose age is greater than 30
    // - name should be unique
    // - name should be in sorted order
    public static void personNameUniqueAndSorted() {
        Person p1 = new Person("Mohan", "kumar", 56, Arrays.asList("Red", "White", "Blue"));
        Person p2 = new Person("Pihu", "kumari", 60, Arrays.asList("Red", "White", "Blue"));
        Person p3 = new Person("Paurush", "Dewang", 58, Arrays.asList("Red", "White", "Blue"));
        Person p4 = new Person("David", "D", 30, Arrays.asList("Red", "White", "Blue"));
        Person p5 = new Person("Paurush", "Dewang", 76, Arrays.asList("Red", "White", "Blue"));

        List<Person> persons = new ArrayList<>();
        persons.add(p5);
        persons.add(p4);
        persons.add(p3);
        persons.add(p2);
        persons.add(p1);

        List<Person> badPractice = persons.stream().filter(p -> p.getAge() > 30).sorted(
                Comparator.comparing(Person::getFirstName)
        ).distinct().toList();
//        System.out.println(badPractice);

        List<String> personGreater30 = persons.stream()
                .filter(p -> p.getAge() > 30)
                .map(Person::getFirstName)
                .toList();
//        System.out.println(personGreater30);

        List<String> uniqueSortedName = personGreater30.stream()
                .sorted().distinct().toList();

//        System.out.println(uniqueSortedName);


        // Given a Person Object where each person has a first name and last name.
        // Sort the List<Person> by their first name then by last Name.
        List<Person> firstNameThenLastName = persons.stream()
                .sorted(
                        Comparator.comparing(Person::getFirstName)
                                .thenComparing(Person::getLastName)
                ).toList();
        System.out.println(firstNameThenLastName);
    }

    // Concatenate 2 streams using Stream API
    public static void concatenateTwoStream() {
        Stream<String> stream1 = Stream.of("Java", "Python");
        Stream<String> stream2 = Stream.of("C++", "C#");
        Stream<String> ans = Stream.concat(stream1, stream2);
        System.out.println(ans.toList());
    }

    // What is the difference between map and flatmap
    public static void mapAndFlatMap() {
        Person p1 = new Person("Mohan", "kumar", 26, Arrays.asList("Red", "White", "Blue"));
        Person p2 = new Person("Pihu", "kumar", 6, Arrays.asList("Red", "White", "Blue"));
        Person p3 = new Person("Paurush", "kumar", 28, Arrays.asList("Red", "White", "Blue"));
        Person p4 = new Person("David", "kumar", 30, Arrays.asList("Red", "White", "Blue"));
        Person p5 = new Person("Dayal", "kumar", 76, Arrays.asList("Red", "White", "Blue"));
        List<Person> persons = new ArrayList<>();
        persons.add(p5);
        persons.add(p4);
        persons.add(p3);
        persons.add(p2);
        persons.add(p1);

        // map() transforms each element of the stream into another element. It is a one-to-one mapping.
        //Use of map() when you have a stream of element and want to apply a function to each element.
        List<List<String>> colorListofList = persons.stream()
                .map(p -> p.getColor())
                .toList();
        System.out.println(colorListofList);

// flatMap() transforms + flattens the resulting streams into one stream, usully when we are dealing with collections of collections.
        List<String> colorList = persons.stream()
                .flatMap(p -> p.getColor().stream())
                .toList();
        System.out.println(colorList);

    }

    // Given a list of string convert it into uppercase and combine it into a single
    // spring
    public static void uppercaseAndCombineString() {
        List<String> list = Arrays.asList("ramanuj", "Mishra");
        String ans = list.stream()
                .map(str -> str.toUpperCase())
                .reduce((s1, s2) -> s1 + "" + s2).orElse(null);
        System.out.println(ans);
    }

    // Convert a list to a map. Given a Person object list convert it to a map with
    // a key as "name" and value as List<Person>.
    public static void convertListToMap() {
        Person p1 = new Person("Mohan", "kumar", 26, Arrays.asList("Red", "White", "Blue"));
        Person p2 = new Person("Pihu", "kumar", 6, Arrays.asList("Red", "White", "Blue"));
        Person p3 = new Person("Paurush", "kumar", 28, Arrays.asList("Red", "White", "Blue"));
        Person p4 = new Person("David", "kumar", 30, Arrays.asList("Red", "White", "Blue"));
        Person p5 = new Person("Dayal", "kumar", 76, Arrays.asList("Red", "White", "Blue"));
        List<Person> persons = new ArrayList<>();
        persons.add(p5);
        persons.add(p4);
        persons.add(p3);
        persons.add(p2);
        persons.add(p1);

        Map<String, List<Person>> map = persons.stream()
                .collect(Collectors.groupingBy(
                        person -> person.getFirstName()));
        System.out.println(map);
    }

    // Given a list of strings, group them by their first character and count the
    // number of strings in each group.
    public static void groupByFirstCharacterAndCountTheFreq() {
        List<String> strings = Arrays.asList("apple", "banana", "avocado", "apricot", "cherry", "blueberry");
        Map<Character, Long> map = strings.stream()
                .collect(Collectors.groupingBy(
                        str -> str.charAt(0),
                        Collectors.counting()));
        System.out.println(map);
    }

    /*
     * Transfrom Person object stream into a single string consisting of all names
     * in upper letters separated(pipe) character.
     * output - MOHAN | PIHU | PAURUSH | DAVID | DAYAL
     *
     */

    // Lecture no - 36
    // public static void nameSeparatedWithPipe(){
    // Person p1 = new Person("Mohan", 26);
    // Person p2 = new Person("Pihu", 6);
    // Person p3 = new Person("Paurush", 28);
    // Person p4 = new Person("David", 30);
    // Person p5 = new Person("Dayal", 76);
    // List<Person> persons = new ArrayList<>();
    // persons.add(p5);
    // persons.add(p4);
    // persons.add(p3);
    // persons.add(p2);
    // persons.add(p1);

    // persons.stream()
    // .map((p)->{

    // }).toList();
    // }

    // There is a list of Employee objects having field name and email. Find the
    // list of domains(gmail.com, yahoo.com, genpact.com) And the occurrences of
    // each domain.
    public static void domainNamewithFreq() {
        List<String> emailList = Arrays.asList(
                "null@gmail.com",
                "abc@genpact.com",
                "zyz@gmail.com", "ram@paypal.com");

        Map<String, Long> map = emailList.stream()
                .filter(str -> str.contains("@"))// it check either @ is present or not.
                .map(str -> str.substring(str.indexOf("@") + 1))
                .collect(Collectors.groupingBy(
                        x -> x,
                        LinkedHashMap::new,
                        Collectors.counting()));
        System.out.println(map);

    }

    // Convert a list of strings to uppercase
    public static void convertStringToUpperCase() {
        List<String> list = Arrays.asList(
                "abc", "dev", "null", "hello", "Hello");

        List<String> ans = list.stream()
                .map(x -> x.toUpperCase())
                .toList();
        System.out.println(ans);
    }

    // Find the Strings that containing only digits
    public static void containingDigits() {
        List<String> list = Arrays.asList("1232", "332", "null", "ab12ad", "a12gs1dfd3");
        Pattern pattern = Pattern.compile("[0-9]+");
        List<String> ans = list.stream()
                .filter(s -> pattern.matcher(s).matches())
                .toList();
        System.out.println(ans);
    }
    /*
     * 🔹 Step 1: Stream traversal
     * list.stream() → creates a stream of strings, not characters.
     * So iteration is happening string by string, not character by character.
     * First "1232", then "332", then "null", etc.
     * 🔹 Step 2: Applying the regex
     * For each string s, this runs:
     * pattern.matcher(s).matches()
     * pattern.matcher(s) creates a Matcher object for the whole string s.
     * .matches() tries to match the entire string against [0-9]+.
     * 🔹 Step 3: What [0-9]+ means
     * It doesn’t loop through characters manually.
     * The regex engine does the character-by-character matching internally.
     *
     * So when you pass "1232", the regex engine checks:
     * '1' ✅ is a digit
     * '2' ✅ is a digit
     * '3' ✅ is a digit
     * '2' ✅ is a digit
     * → The whole string matches → true.
     *
     * But for "ab12ad", the regex engine checks:
     * 'a' ❌ not a digit → fails immediately → false.
     */

    // Remove all non-numeric characters for a list
    public static void removeAllNumericCharacter() {
        List<String> list = Arrays.asList("nu3r3ll", "ab12ad", "a12gs1dfd3", "sf3df34f3");
        /*
         * Ans should be 22, 12, 1213,3343
         *
         * The Idea is we are taking a regex that should not be number "[^0-9]" And
         * store it into Pattern
         * Now traverse throught the string character and If we get non-numeric charater
         * then replace it with empty string.
         *
         */

        Pattern pattern = Pattern.compile("[^0-9]");

        List<String> ans = list.stream()
                .map(x -> pattern.matcher(x).replaceAll(""))
                .toList();

        System.out.println(ans);

    }

    // convert a list of string a list of the length of the string
    public static void convertListOfStringIntoItsLength() {
        List<String> list = Arrays.asList("null", "Ram", "Rom", "test");
        List<Integer> lengthOfList = list.stream().map(x -> x.length()).toList();
        System.out.println(lengthOfList);
    }

    // Sort a list of Strings in alphabetical order
    public static void sortListOfStringInAlphabeticalOrder() {
        List<String> str = Arrays.asList("Zudio", "Puma", "Addidas", "MAC", "H&M");
        List<String> sortedString = str.stream().sorted().toList();
        System.out.println(sortedString);
    }

    // given the string[] group the strings based on the middle character.
    public static void groupStringBasedOnMiddleCharacter() {
        // output {w = [ewe,kwk], h = [jhj, aha], j = [jji]}
        String[] str = {"ewewwwer", "jjrie", "jhjrre", "kwk", "aha"};
        Map<String, List<String>> map = Arrays.stream(str)
                .collect(Collectors.groupingBy(x -> x.substring(x.length() / 2, x.length() / 2 + 1)));

        System.out.println(map);
    }

    // List of String arrange the string into ascending order according to it's
    // length. If two of String has equal length arrange it with their
    // alphabetically
    // order
    public static void arrangeListOfStringInAscendingOrderWithAlphabeticalOrder() {
        List<String> list = Arrays.asList("apple", "a", "kiwi", "fog", "frog", "banana", "fig", "pineapple");
        List<String> sortedString = list.stream()
                .sorted(
                        Comparator.comparingInt((String s) -> s.length())
                                .thenComparing(Comparator.naturalOrder()))
                .toList();
        System.out.println(sortedString);
    }

    public static void arrangeListOfStringInAscendingOrder() {
        List<String> list = Arrays.asList("apple", "a", "kiwi", "banana", "fig", "pineapple");
        List<String> sortedString = list.stream()
                .sorted(Comparator.comparingInt(s -> s.length()))
                .toList();
        System.out.println(sortedString);
    }

    // Given a String, find the first non-repeated character
    public static void findFirstNonRepeatedCharacterWithStream() {
        String s = "Hello World He";
        /** O(n) */
        Optional<Character> findFirst = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        ch -> ch, // key = character
                        LinkedHashMap::new, // preserve order
                        Collectors.counting() // count occurrences
                ))
                .entrySet()
                .stream()
                .filter(e -> {
                    if (e.getKey() != ' ')
                        return e.getValue() == 1;
                    return false;
                }) // keep only repeated ones
                .map(Map.Entry::getKey) // get the character
                .findFirst(); // first in original order

        if (findFirst.isPresent())
            System.out.println("First non repeated char :: " + findFirst.get());

        /** O(n^2) */
        Optional<Character> findNonRepeated = s.chars()
                .mapToObj(c -> {
                    return (char) c;
                })
                .filter(ch -> {
                    List<Character> list = s.chars()
                            .mapToObj(c -> (char) c)
                            .toList();
                    int freq = 0;
                    if (ch != ' ')
                        freq = Collections.frequency(list, ch);

                    return freq == 1;
                })
                .findFirst();
        if (findNonRepeated.isPresent()) {
            System.out.println("First Non Repeated Character :: " +
                    findNonRepeated.get());
        }
    }

    // Given a String, find the first repeated character
    public static void findFirstRepeatedCharacterWithStream() {
        String s = "Hello World";
        /** O(n) */
        Optional<Character> findFirst = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        ch -> ch, // key = character
                        LinkedHashMap::new, // preserve order
                        Collectors.counting() // count occurrences
                ))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 1) // keep only repeated ones
                .map(Map.Entry::getKey) // get the character
                .findFirst(); // first in original order

        if (findFirst.isPresent())
            System.out.println("First non repeated char :: " + findFirst.get());

        /** O(n^2) */
        // Optional<Character> firstRepeated = s.chars() // IntStream of character codes
        // [72, 101, 108, 108, 111, 32, 87, 111, 114, 108, 100]
        // .mapToObj(c -> (char) c) // Convert to Character ['H', 'e', 'l', 'l', 'o', '
        // ', 'W', 'o', 'r', 'l', 'd']
        // .filter(ch ->{
        // List<Character> list = s.chars()
        // .mapToObj(c -> (char)c)
        // .toList();
        // // System.out.println(list); ['H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r',
        // 'l', 'd']
        // int freq = Collections.frequency(list, ch);
        // return freq > 1;
        // } ) // Keep only repeated characters
        // .findFirst(); // Get first one

        // if (firstRepeated.isPresent()) {
        // System.out.println("First Repeated Character :: " + firstRepeated.get());
        // } else {
        // System.out.println("All characters are unique");
        // }
    }

    public static void findFirstRepeatedCharacter() {
        String s = "Hello World";
        int arr[] = new int[256];
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)]++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i)] > 1) {
                System.out.println("First Repeated Character :: " + s.charAt(i));
                flag = true;
                break;
            }
        }
        if (!flag)
            System.out.println("All characters are unique");

    }

    // Given a sentence, find the words with a specified number of vowels
    public static void findWordsWithRespectToVowel() {
        String s = "Given a sentence, find the words with a specified number of vowels";
        int vowels = 2;
        Arrays.stream(s.split(" "))
                .filter(x -> x.replaceAll("[^aeiouAEIOU]", "").length() == vowels)
                .forEach(System.out::println);

    }

    // Find the occurrence of each word
    public static void occurrenceOfEachWord() {
        String s = "word of each occurrence Find the occurrence of each word";
        Arrays.stream(s.split(" "))
                .collect(Collectors.groupingBy(
                        word -> word,
                        // word -> word.length()
                        Collectors.counting()))
                .forEach((word, count) -> System.out.println(word + " " + count));
        // Map<String, Integer> map = new HashMap<>();
        // for(String word : s.split(" ")){
        // map.put(word, map.getOrDefault(word, 0)+1);
        // }
        // for(Map.Entry<String, Integer> e: map.entrySet())
        // System.out.println(e.getKey()+ " "+ e.getValue());
    }

    // Find the 2nd highest length word in a sentence
    public static void find2ndHighest() {
        String s = "Find the 2nd highest length word in a sentence";

        String string = ",";
        Arrays.stream(s.split(" "))
                .sorted((w1, w2) -> Integer.compare(w2.length(), w1.length()))
                .forEach(word -> System.out.print(word + " "));

        System.out.println();
        int secondHighest = Arrays.stream(s.split(" "))
                .map(String::length)
                .sorted(Comparator.reverseOrder())
                .skip(0)
                .findFirst()
                .get();

        System.out.println(secondHighest);
        String secondHighestString = Arrays.stream(s.split(" "))
                .sorted(Comparator.reverseOrder())
                .skip(0)
                .findFirst()
                .get();

        System.out.println(secondHighestString);
    }

}
