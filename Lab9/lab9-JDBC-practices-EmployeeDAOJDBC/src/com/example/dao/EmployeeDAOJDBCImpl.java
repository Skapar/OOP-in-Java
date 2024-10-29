package com.example.dao;

import com.example.model.Employee;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;

public class EmployeeDAOJDBCImpl implements EmployeeDAO {

    private Connection con = null;

    EmployeeDAOJDBCImpl() {
        String url = "jdbc:postgresql://localhost:5432/employeedb";
        String username = "postgres";
        String password = "123";

        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException se) {
            System.out.println("Error obtaining connection with the database: " + se);
            System.exit(-1);
        }
    }

    @Override
    public void add(Employee emp) throws DAOException {
        try (Statement stmt = con.createStatement()) {
            String query = "INSERT INTO employee VALUES (" + emp.getId() + ", '" + emp.getFirstName() + "', "
                    + "'" + emp.getLastName() + "', "
                    + "'" +
                    new java.sql.Date(emp.getBirthDate().getTime()) + "', "
                    + emp.getSalary() + ")";

            if (stmt.executeUpdate(query) != 1) {
                throw new DAOException("Error: No employee added");
            }
        } catch (SQLException se) {
            throw new DAOException("Error executing SQL query", se);
        }
    }

    @Override
    public void update(Employee emp) throws DAOException {
        try (Statement stmt = con.createStatement()) {
            String query = "UPDATE employee SET FIRSTNAME='" + emp.getFirstName() + "', "
                    + "LASTNAME='" + emp.getLastName() + "', "
                    + "BIRTHDATE='" + new java.sql.Date(emp.getBirthDate().getTime()) + "', "
                    + "SALARY=" + emp.getSalary() + " "
                    + "WHERE ID=" + emp.getId();

            if (stmt.executeUpdate(query) != 1) {
                throw new DAOException("ERROR updating employee");
            }
        } catch (SQLException se) {
            throw new DAOException("ERROR updating employee in DAO", se);
        }
    }

    @Override
    public void delete(int id) throws DAOException {
        Employee emp = findById(id);
        if (emp == null) {
            throw new DAOException("Employee id: " + id + " does not exist to delete.");
        }

        try (Statement stmt = con.createStatement()) {
            String query = "DELETE FROM employee WHERE ID=" + id;
            if (stmt.executeUpdate(query) != 1) {
                throw new DAOException("ERROR deleting employee");
            }
        } catch (SQLException se) {
            throw new DAOException("ERror deleting in DAO");
        }
    }

    @Override
    public Employee findById(int id) throws DAOException {
        try (Statement stmt = con.createStatement()) {
            String query = "SELECT * FROM employee where id=" + id;
            ResultSet rs = stmt.executeQuery(query);

            if (!rs.next()) {
                return null;
            }
            return (new Employee(rs.getInt("ID"),
                    rs.getString("FIRSTNAME"),
                    rs.getString("LASTNAME"),
                    rs.getDate("BIRTHDATE"),
                    rs.getFloat("SALARY")));
        } catch (SQLException se) {
            throw new DAOException("Error finding employee in DAO", se);
        }
    }

    @Override
    public Employee[] getAllEmployees() throws DAOException {
        try (Statement stmt = con.createStatement()) {
            String query = "SELECT * FROM employee";
            ResultSet rs = stmt.executeQuery(query);

            ArrayList<Employee> emps = new ArrayList<>();
            while (rs.next()) {
                emps.add(new Employee(rs.getInt("ID"),
                        rs.getString("FIRSTNAME"),
                        rs.getString("LASTNAME"),
                        rs.getDate("BIRTHDATE"),
                        rs.getFloat("SALARY")));
            }

            return emps.toArray(new Employee[0]);
        }
        catch (SQLException se) {
            throw new DAOException("Error getting all employees in DAO", se);
        }
    }

    @Override
    public void close() throws Exception {
        try {
            con.close();
        } catch (SQLException se) {
            System.out.println("Error closing connection" + se);
        }
    }
}
