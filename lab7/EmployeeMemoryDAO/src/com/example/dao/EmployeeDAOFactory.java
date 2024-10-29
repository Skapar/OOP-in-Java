package com.example.dao;

import com.example.model.Employee;

public class EmployeeDAOFactory {

    public EmployeeDAO createEmployeeDAO(){
        return new EmployeeDAOMemoryImpl();
    }
}
