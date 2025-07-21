package com.org.stream;

public class Employee {
    private final long id;
    private final String name;
    private final Double salary;
    private final String dept;

    public Employee(long id, String name, Double salary, String dept){
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.dept = dept;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public Double getSalary() {
        return salary;
    }

    public String getDept() {
        return dept;
    }

    @Override
    public String toString(){
        return "{" +
                "id :: "+  id +
                " name :: "+ name +
                " salary :: "+ salary +
                " dept :: "+ dept +
                " }";
    }
}
