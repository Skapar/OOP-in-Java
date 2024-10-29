package com.example.domain;

public class Employee {
    protected final int employeeId;
    protected String employeeName;
    protected final String employeeSocialSecurityNumber;
    protected double employeeSalary;

    public Employee(int empId, String name, String ssn, double salary) {
        this.employeeId = empId;
        this.employeeName = name;
        this.employeeSocialSecurityNumber = ssn;
        this.employeeSalary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeeSocialSecurityNumber() {
        return employeeSocialSecurityNumber;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void raiseSalary(double increase) {
        this.employeeSalary += increase;
    }
}






