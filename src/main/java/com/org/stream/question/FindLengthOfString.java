package com.org.stream.question;

import com.org.stream.Employee;
import com.org.stream.EmployeeImp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FindLengthOfString {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list = EmployeeImp.addInList();
        employeeNameLength(list);

    }
    // Count the number of Employee whose name of length is greater than 3
    public static void employeeNameLength(List<Employee> list){

        String empName = list.stream()
                .max(Comparator.comparingInt(employee -> employee.getName().length()))
                .get().getName();
        System.out.println(empName);
        long totalEmployee = list.stream()
                .mapToInt(employee -> employee.getName().length())
                .filter(length -> length > 3)
                        .count();
        System.out.println(totalEmployee);
    }
}
