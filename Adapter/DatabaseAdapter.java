package Adapter;

import java.util.Vector;

public class DatabaseAdapter implements EmployeeDatabase {
    private Database database;

    public DatabaseAdapter(Database database) {
        this.database = database;
    }

    @Override
    public void addEmployee(Employee e) {
        database.addEmployee(e);
    }

    @Override
    public void deleteEmployee(long emp_num) {
        database.deleteEmployee(emp_num);
    }

    @Override
    public boolean employeeExists(long emp_num) {
        Vector<Employee> employees = database.getEmployees();
        for (Employee e : employees) {
            if (e.getEmpNum() == emp_num) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void printEmployees() {
        Vector<Employee> employees = database.getEmployees();
        for (Employee e : employees) {
            System.out.println(e.getEmpNum() + " " + e.getName() + " " + e.getSurname() + " $" + e.getSalary());
        }
    }
}
