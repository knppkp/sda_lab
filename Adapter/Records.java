/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adapter;

import java.util.*;

/**
 *
 * @author boonjv
 */
public class Records {

    private ArrayList<Employee> employees; //Stores the employees

    public Records() {
        employees = new ArrayList<>();
    }

    public void insert(Employee employee) {
        //Code to insert employee
        employees.add(employee);
    }

    public void remove(long emp_num) {
        //Code to remove employee
        employees.removeIf(e -> e.getEmpNum() == emp_num);
    }

    public boolean isEmployee(long emp_num) {
        //Code to find employee
        for (Employee e : employees) {
            if (e.getEmpNum() == emp_num) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

}
