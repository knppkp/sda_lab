package Adapter;

public interface EmployeeDatabase {
    void addEmployee(Employee e);
    void deleteEmployee(long emp_num);
    boolean employeeExists(long emp_num);
    void printEmployees();
}
