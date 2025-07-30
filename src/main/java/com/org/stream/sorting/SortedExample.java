package com.org.stream.sorting;

import com.org.stream.Employee;
import com.org.stream.EmployeeImp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortedExample {
    // There are two type of sorting Ascending or Descending
    // For ascending use sorted() or sorted(Comparator.naturalOrder()) or sorted((o1,o2) -> o1.compareTo(o2))
    // For Descending use sorted(Comparator.reverseOrder()) or sorted((o1,o2) -> o2.compareTo(o1))
    public static void main(String[] args) {
        List<Integer> number = Arrays.asList(2,1,23,4,4,5,677,53,2,43,32,21,12,2,455,6,77,88,88);
        System.out.println(sortInNaturalSortingOrder(number));

        System.out.println(sortInReverseSortingOrder(number));

        List<Employee> employeeList = EmployeeImp.addInList();

        sortEmployeeInAscendingOrderByTheirSalary(employeeList);
        sortEmployeeInAscendingOrderByTheirName(employeeList);

    }


    private static List<Integer> sortInReverseSortingOrder(List<Integer> number) {
        List<Integer> usingCompareTo = number.stream()
                .sorted((o1,o2) -> o2.compareTo(o1))
                .toList();
        System.out.println("Reverse using compareTo method "+ usingCompareTo);

        return number.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    private static List<Integer> sortInNaturalSortingOrder(List<Integer> number) {
        List<Integer> usingCompareTo = number.stream()
                .sorted((o1,o2) -> o1.compareTo(o2))
                .toList();
        System.out.println("using compareTo method "+ usingCompareTo);
        List<Integer> usingComparator = number.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        System.out.println("Using natural sorting order " + usingComparator);

        return number.stream()
                .sorted()
                .collect(Collectors.toList());
    }
    private static void sortEmployeeInAscendingOrderByTheirSalary(List<Employee> employeeList) {
        List<Employee> employees = employeeList.stream()
                .sorted((e1,e2) -> e1.getSalary().compareTo(e2.getSalary()))
                .collect(Collectors.toList());

        System.out.println(employees);
        employeeList.stream()
                .sorted((e1,e2) -> e2.getSalary().compareTo(e1.getSalary()))
                .forEach(System.out::println);
    }

    private static void sortEmployeeInAscendingOrderByTheirName(List<Employee> employeeList) {
        employeeList.stream()
                .sorted((e1,e2) -> e1.getName().compareTo(e2.getName()))
                .forEach(System.out::println);
    }
}
