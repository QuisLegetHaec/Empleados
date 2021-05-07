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

    /**
     * Adds an employee object to the ArrayList.
     */
    private void addEmployees() {
        System.out.println("How many employees would you like to add to the system?");
        System.out.println("Enter a number: ");
        int num = validateInt();

        for (int i = 0; i < num; i++) {
            System.out.println("Employee " + (i + 1) + " to be added");
            Employee emp = insertEmployee();
            employees.add(emp);
        }
    }

    /**
     * Inserts (adds) an employee object into the ArrayList<Employee>
     */
    private Employee insertEmployee() {
        System.out.println("Enter employee's name: ");
        String name = sc.nextLine();
        System.out.println("Enter employee's salary: ");
        Double salary = validateDouble();
        LocalDate startDate = validateDate();
        Employee emp = new Employee(name, salary, startDate);
        return emp;
    }

    /**
     * Prints to console a list of the employees withint the ArrayList<Employee>
     */
    private void showEmployees() {
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }

    /**
     * Delete employee according the name specified by the user
     */
    private void deleteEmployee() {
        int counter = 0;
        System.out.println("Enter the name of the person you wish to delete: ");
        String name = sc.nextLine();

        for (Employee empl: employees) {
            if (empl.getName().equals(name)) {
                employees.remove(empl);
                System.out.println("Employee " + name + " deleted");
                counter++;
                break;
            }
        }

        if (counter == 0) {
            System.out.println("No employees matched this name.");
        }
    }

    /**
     * Print to console the employee object at the user specified index provided within bounds.
     */
    private void checkListPos() {
        System.out.println("Enter index you wish to check: ");
        int index = validateInt();

        if (employees.size() < index) {
            System.out.println("The index does not exist.");
        } else {
            System.out.println(employees.get(index));
        }
    }

    private void modifyEmployee() {}

    /**
     * Add an employee object to the ArrayList<Employee> at the user specified index position provided it is within
     * bounds.
     */
    private void insertSpecPos() {
        int arrSize = employees.size();

        System.out.println("At what index position do you want to insert the new employee (between 0 and " + (arrSize - 1) + "): ");
        int indexPos = validateInt();

        if (indexPos >= 0 && indexPos <= arrSize) {
            Employee emp = insertEmployee();
            employees.add(indexPos, emp);
        } else {
            System.out.println("The index does not exist.");
        }
    }

    private void avgDuration() {}

    private void longestServingEmployee() {}

    /**
     * Print to console the employee object whose salary is the lowest.
     */
    private void lowestPaidEmployee() {

    }

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
