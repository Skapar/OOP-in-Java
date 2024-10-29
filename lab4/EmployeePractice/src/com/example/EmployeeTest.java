package com.example;

import com.example.domain.Employee;
import com.example.domain.*;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee employee = new Employee(101, "John Doe", "123-45-6789", 50000.0);
        printEmployee(employee);

        Manager managerJane = new Manager(101, "Jane Smith", "012-34-5678", 120345.27, "US Marketing");
        printManager(managerJane);

        Manager managerBarbara = new Manager(207, "Barbara Johnson", "054-12-2367", 109501.36, "US Marketing");
        printManager(managerBarbara);

        Employee admin = new Admin(304, "Bill Monroe", "108-23-6509", 75002.34);
        printEmployee(admin);

        Director director = new Director(12, "Susan Wheeler", "099-45-2340", 120567.36, "Global Marketing", 1_000_000.00);
        printDirector(director);

        employee.raiseSalary(5000.0);
        employee.setEmployeeName("John Doe Jr.");

        System.out.println("\nUpdated Employee:");
        printEmployee(employee);
    }

    public static void printEmployee(Employee employee) {
        System.out.println("Employee ID: " + employee.getEmployeeId());
        System.out.println("Employee Name: " + employee.getEmployeeName());
        System.out.println("Employee SSN: " + employee.getEmployeeSocialSecurityNumber());
        System.out.println("Employee Salary: " + formatCurrency(employee.getEmployeeSalary()));
        System.out.println();
    }

    public static void printManager(Manager manager) {
        printEmployee(manager);
        System.out.println("Manager Department: " + manager.getDeptName());
        System.out.println();
    }

    public static void printDirector(Director director) {
        printManager(director);
        System.out.println("Director Budget: " + formatCurrency(director.getBudget()));
        System.out.println();
    }

    private static String formatCurrency(double amount) {
        return String.format("$%.2f", amount);
    }
}
