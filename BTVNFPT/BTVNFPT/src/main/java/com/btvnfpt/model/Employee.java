package com.btvnfpt.model;

public class Employee {
    private int idEmployee;
    private String employeeCode;
    private String nameEmployee;
    private int age;
    private String img;
    private int salary;
    private Branch branch;

    public Employee() {
    }

    public Employee(int idEmployee, String employeeCode, String nameEmployee, int age, String img, int salary, Branch branch) {
        this.idEmployee = idEmployee;
        this.employeeCode = employeeCode;
        this.nameEmployee = nameEmployee;
        this.age = age;
        this.img = img;
        this.salary = salary;
        this.branch = branch;
    }
    public Employee(String employeeCode, String nameEmployee, int age, String img, int salary, Branch branch) {
        this.employeeCode = employeeCode;
        this.nameEmployee = nameEmployee;
        this.age = age;
        this.img = img;
        this.salary = salary;
        this.branch = branch;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
