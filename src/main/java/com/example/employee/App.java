package com.example.employee;

import com.example.employee.dao.EmployeeDAO;
import com.example.employee.model.Employee;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        EmployeeDAO dao = new EmployeeDAO();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Add Employee\n2. View Employees\n3. Update Employee\n4. Delete Employee\n5. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Salary: ");
                    double salary = sc.nextDouble();
                    dao.addEmployee(new Employee(0, name, email, salary));
                    break;
                case 2:
                    List<Employee> employees = dao.getAllEmployees();
                    for (Employee e : employees) {
                        System.out.println(e);
                    }
                    break;
                case 3:
                    System.out.print("ID to update: ");
                    int upId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New Name: ");
                    String upName = sc.nextLine();
                    System.out.print("New Email: ");
                    String upEmail = sc.nextLine();
                    System.out.print("New Salary: ");
                    double upSalary = sc.nextDouble();
                    dao.updateEmployee(new Employee(upId, upName, upEmail, upSalary));
                    break;
                case 4:
                    System.out.print("ID to delete: ");
                    int delId = sc.nextInt();
                    dao.deleteEmployee(delId);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
            }
        }
    }
}
