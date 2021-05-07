package com.philippabather.empleados;

import domain.Employee;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import static com.philippabather.empleados.ValidationUtils.*;

/**
 * Menu class displays menu interface to the user in the console.
 */
public class Menu {

    //declare instance fields
    private static final Scanner sc = new Scanner(System.in);
    private ArrayList<Employee> employees = new ArrayList<Employee>();

    public void executeMenu() {
        boolean exit = false;

        do {

            System.out.println("###################################################################");
            System.out.println("\n                          Employees                             ");
            System.out.println("\n------------------------------------------------------------------");
            System.out.println("1. Add employees");
            System.out.println("2. Show all employees");
            System.out.println("3. Delete an employee");
            System.out.println("4. Check employee according to index number");
            System.out.println("5. Modify employee details");
            System.out.println("6. Add employee at specified index");
            System.out.println("7. Show average length of service");
            System.out.println("8. Show longest serving employee details");
            System.out.println("9. Show lowest paid employee details");
            System.out.println("10. Exit");

            System.out.println("\nChoose option: ");
            int option = validateInt();


            switch (option) {
                case 1:
                    addEmployees();
                    break;
                case 2:
                    showEmployees();
                    break;
                case 3:
                    deleteEmployee();
                    break;
                case 4:
                    checkListPos();
                    break;
                case 5:
                    modifyEmployee();
                    break;
                case 6:
                    insertSpecPos();
                    break;
                case 7:
                    avgDuration();
                    break;
                case 8:
                    longestServingEmployee();
                    break;
                case 9:
                    lowestPaidEmployee();
                    break;
                case 10:
                    exit = exitProg();
                    break;
                default:
                    System.out.println("Choice not recognised.\n");
            }

        } while (!exit);
    }

    private void addEmployees() {
        System.out.println("How many employees would you like to add to the system?");
        System.out.println("Enter a number: ");
        int num = validateInt();

        for (int i = 0; i < num; i++) {
            System.out.println("Employee " + (i + 1) + " to be added");
            System.out.println("Enter employee's name: ");
            String name = sc.nextLine();
            System.out.println("Enter employee's salary: ");
            Double salary = validateDouble();
            LocalDate startDate = validateDate();
            Employee emp = new Employee(name, salary, startDate);
            employees.add(emp);
        }
    }

    private void showEmployees() {
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }

    private void deleteEmployee() {}

    private void checkListPos() {}

    private void modifyEmployee() {}

    private void insertSpecPos() {}

    private void avgDuration() {}

    private void longestServingEmployee() {}

    private void lowestPaidEmployee() {}

    /**
     * Exits programme and notify user
     * @return boolean
     */
    private boolean exitProg() {
        boolean exit = true;
        System.out.println("Exiting the programme.");
        return exit;
    }
}
