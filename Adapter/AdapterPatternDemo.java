package Adapter;

public class AdapterPatternDemo {
    public static void main(String[] args) {
        Employee e1 = new Employee("Alice", "Smith", 101, 50000);
        Employee e2 = new Employee("Bob", "Brown", 102, 60000);

        System.out.println("\nUse Database Adapter\n");

        // Use Database via Adapter
        Database db = new Database();
        EmployeeDatabase dbAdapter = new DatabaseAdapter(db);

        dbAdapter.addEmployee(e1);
        dbAdapter.addEmployee(e2);
        System.out.println("List all Employees");
        dbAdapter.printEmployees();
        System.out.println("-----------------");
        System.out.println("Exists (101)? " + dbAdapter.employeeExists(101));
        System.out.println("-----------------");
        System.out.println("Delete 101");
        dbAdapter.deleteEmployee(101);
        System.out.println("List all Employees");
        dbAdapter.printEmployees();


        System.out.println("\nUse Record Adapter\n");
        // Use Records via Adapter
        Records rec = new Records();
        EmployeeDatabase recAdapter = new RecordsAdapter(rec);

        recAdapter.addEmployee(e1);
        recAdapter.addEmployee(e2);
        System.out.println("List all Employees");
        recAdapter.printEmployees();
        System.out.println("-----------------");
        System.out.println("Exists (101)? " + recAdapter.employeeExists(101));
        System.out.println("-----------------");
        System.out.println("Delete 101");
        recAdapter.deleteEmployee(101);
        System.out.println("List all Employees");
        recAdapter.printEmployees();
    }
}
