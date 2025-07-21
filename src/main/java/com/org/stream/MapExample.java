package com.org.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapExample {
    /**
     *  map is an Intermediate function.
     *  map is not reduce number of item that is present in the stream
     *  map is transfer each and every element which is present in the stream into some other object.
     *  It returns a stream.
     *  And we can use any Collector operator and collect it.
     * */
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,11,1,1,11,1111,22,3,444);

        List<Integer> sumBy2 = sumEachElementBy2(list);
        System.out.println(sumBy2);

        List<String> fruits = Arrays.asList("apple", "Banana", "Guava", "Lichi");
        List<String> convertUpperCase = convertUpperCase(fruits);
        System.out.println(convertUpperCase);

        List<Employee> employeeList = EmployeeImp.addInList();
        // Now I hava list of employee I want to fetch salary of all employee from the employeeList
        // 1. A list of salary
        // 2. And we know map method exactly return the list/stream best on operation.
        // 3. So we use map here.

        List<Double> salaryList = findSalaryFromEmployeeList(employeeList);
        System.out.println(salaryList);

    }

    private static List<Double> findSalaryFromEmployeeList(List<Employee> employeeList) {
        return employeeList.stream()
                .map(employee -> {
                    return employee.getSalary();
                }
                )
                .toList();

//        return employeeList.stream()
//                .map(Employee :: getSalary)
//                .toList();
    }

    private static List<String> convertUpperCase(List<String> fruits) {
//        return fruits.stream()
//                .map(fruit -> fruit.toUpperCase())
//                .collect(Collectors.toList());

        /** Replace lambda function with method reference
          fruit -> fruit.toUpperCase() === String::toUpperCase
          */

        return fruits.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    /*
*  So Basically when we want to do some operation in each and every element in the list/Stream
*  Then we use map method
* */
    private static List<Integer> sumEachElementBy2(List<Integer> list) {
        return list.stream()
                .map(n ->n+2)
                .toList();
    }

}
