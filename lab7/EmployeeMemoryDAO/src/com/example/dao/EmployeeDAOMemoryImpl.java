package com.example.dao;

import com.example.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOMemoryImpl implements EmployeeDAO{
    public static Employee[] employeeArray = new Employee[10];


//    protected EmployeeDAOMemoryImpl(){}
    public void add(Employee emp){
        employeeArray[emp.getId()]  = emp;

    }
    public void update(Employee emp){
        employeeArray[emp.getId()] = emp;
    }
    public void delete(int id){
        employeeArray[id] = null;
    }

    public Employee findById(int id ){
        return employeeArray[id];
    }

    @Override
    public Employee[] getAllEmployees() {
        List<Employee> emps = new ArrayList<>();
        for (Employee e : employeeArray) {
            if (e != null) {
                emps.add(e);
            }
        }
        return emps.toArray(new Employee[0]);
    }
}
