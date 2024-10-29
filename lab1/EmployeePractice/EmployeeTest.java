
package com.example;


import com.example.domain.Employee;

public class daDa {

    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.setEmpId(101);
        emp.setName("Jane Smith");
        emp.setSsn("012-34-4567");
        emp.setSalary(120_345.27);
        emp.setHeight(190);

        System.out.println("Employee id:        " + emp.getEmpId());
        System.out.println("Employee name:      " + emp.getName());
        System.out.println("Employee Soc Sec #: " + emp.getSsn());
        System.out.println("Employee salary:    " + emp.getSalary());
        System.out.println("Employee height:     " + emp.getHeight());

    }

}
