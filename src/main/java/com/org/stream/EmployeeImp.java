package com.org.stream;


import java.util.*;
import java.util.stream.Collectors;

public class EmployeeImp {
    public static List<Employee> addInList(){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(11,"Anuj", 70.00, "PP"));
        list.add(new Employee(12, "Ramanuj", 85.00, "LD"));
        list.add(new Employee(22, "Ram", 1000.00, "All"));
        list.add(new Employee(222,"Shyam", 323.00, "HR"));

        list.add(new Employee(112,"Anuj2", 702.00, "PP"));
        list.add(new Employee(122, "Ramanuj2", 852.00, "LD"));
        list.add(new Employee(222, "Ram2", 10002.00, "All"));
        list.add(new Employee(2222,"Shyam2", 3232.00, "HR"));

        list.add(new Employee(111,"Anuj1", 701.00, "PP"));
        list.add(new Employee(121, "Ramanuj1", 851.00, "LD"));
        list.add(new Employee(221, "Ram1", 10001.00, "All"));
        list.add(new Employee(2221,"Shyam1", 3231.00, "HR"));
        return list;
    }
    public static void main(String[] args) {
        List<Employee> list = addInList();


//        findHighestSalary(list);
//        findAverageSalary(list);
//        usingStreamFindHighestSalaryDeptBy(list);
        increaseSalaryBy5Present(list);

    }

    private static void increaseSalaryBy5Present(List<Employee> list) {
        List<Employee> increasedSalary = list.stream()
                .map(e ->{
                    Double salary = e.getSalary();
                    Double increasedBy5Present = salary + ((salary*5)/100);
                    e.setSalary(increasedBy5Present);
                    return e;
                })
                .toList();
        System.out.println(increasedSalary);
    }

    public static void usingStreamFindHighestSalaryDeptBy(List<Employee> list){
        Map<String, Optional<Employee>> result = list.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDept,
                        Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))
                ));
    }
    public static void findHighestSalary(List<Employee> list){
        Map<String, Double> map = new HashMap<>();

        for(Employee e : list){
            double salary = e.getSalary();
            String dept = e.getDept();
            if(!map.containsKey(dept) || map.get(dept) < salary){
                map.put(dept, salary);
            }
        }

        for(Map.Entry<String , Double> e : map.entrySet()){
            System.out.println(e.getKey() + " :: "+ e.getValue());
        }
    }

    public static void findAverageSalary(List<Employee> list){
         Map<String, Integer> numberOfEmpDeptBy = new HashMap<>();
         Map<String, Double> totalSalaryOfEmpDeptBy =  new HashMap<>();
         Map<String, Double> avgSalaryOfEmpDeptBy = new HashMap<>();
         for(Employee e: list){
             numberOfEmpDeptBy.put(e.getDept(), numberOfEmpDeptBy.getOrDefault(e.getDept(),0)+1);
             String dept = e.getDept();
             Double salary = e.getSalary();
             if(!totalSalaryOfEmpDeptBy.containsKey(dept)){
                 totalSalaryOfEmpDeptBy.put(dept, salary);
             }else{
                 Double existSalary = totalSalaryOfEmpDeptBy.get(dept);
                 totalSalaryOfEmpDeptBy.put(dept, existSalary+salary);
             }
         }

         for(Map.Entry<String, Integer> e: numberOfEmpDeptBy.entrySet()){
             System.out.println(e.getKey() + " :: "+ e.getValue());
         }
         for(Map.Entry<String, Double> e: totalSalaryOfEmpDeptBy.entrySet()){
             System.out.println(e.getKey() +" :: "+ e.getValue());
             String dept = e.getKey();
             Double salary = e.getValue();
             Double avgSalary = salary/numberOfEmpDeptBy.get(dept);
             avgSalaryOfEmpDeptBy.put(dept, avgSalary);
         }
        System.out.println();

         for(Map.Entry<String, Double> e: avgSalaryOfEmpDeptBy.entrySet()){
             System.out.println(e.getKey() + " :: "+ e.getValue());
         }

    }
}
