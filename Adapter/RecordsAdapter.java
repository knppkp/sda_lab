package Adapter;

import java.util.ArrayList;

public class RecordsAdapter implements EmployeeDatabase {
    private Records records;

    public RecordsAdapter(Records records) {
        this.records = records;
    }

    @Override
    public void addEmployee(Employee e) {
        records.insert(e);
    }

    @Override
    public void deleteEmployee(long emp_num) {
        records.remove(emp_num);
    }

    @Override
    public boolean employeeExists(long emp_num) {
        return records.isEmployee(emp_num);
    }

    @Override
    public void printEmployees() {
        ArrayList<Employee> employees = records.getEmployees();
        for (Employee e : employees) {
            System.out.println(e.getEmpNum() + " " + e.getName() + " " + e.getSurname() + " $" + e.getSalary());
        }
    }
}
