package com.org.stream;

public class Employee {
    private  long id;
    private  String name;
    private  Double salary;
    private  String dept;

    public Employee(long id, String name, Double salary, String dept){
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.dept = dept;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void setDept(String dept) {
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
