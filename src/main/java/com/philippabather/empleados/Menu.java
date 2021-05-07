package com.philippabather.empleados;

import domain.DateComparator;
import domain.Employee;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import static com.philippabather.empleados.ValidationUtils.*;

/**
 * Menu class displays menu interface to the user in the console.
 */
public class Menu {

    //declare instance fields
    private static final Scanner sc = new Scanner(System.in);
    private final ArrayList<Employee> employees = new ArrayList<>();

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
                    avg();
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
     * @return empl Employee object
     */
    private Employee insertEmployee() {
        System.out.println("Enter employee's name: ");
        String name = sc.nextLine();
        System.out.println("Enter employee's salary: ");
        double salary = validateDouble();
        LocalDate startDate = validateDate();
        return new Employee(name, salary, startDate);
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
     * Deletes employee according the name specified by the user
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
     * Prints to console the employee object at the user specified index provided within bounds.
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


    private void modifyEmployee() {
        System.out.println("Enter the name of the person you wish to delete: ");
        String name = sc.nextLine();

        for (Employee empl: employees) {
            if (empl.getName().equals(name)) {
                System.out.println("Do you want to modify the employee's name: enter 1 to modify or 0 to continue: ");
                int option = validateOption();
                if (option == 1) { modifyName(empl); }

                System.out.println("Do you want to modify the employee's salary: enter 1 to modify or 0 to continue: ");
                option = validateOption();

                if (option == 1) { modifySalary(empl); }

                System.out.println("Do you want to modify the employee's start date: enter 1 to modify or 0 to continue: ");
                option = validateOption();

                if (option == 1) { modifyStartDate(empl); }

                break;
            }
        }
    }

    /**
     * Modifies an employee's name; invoked by modifyEmployee()
     * @param empl instance of employee
     */
    private void modifyName(Employee empl) {
        System.out.println("Enter the modified name: ");
        String name = sc.nextLine();
        empl.setName(name);
    }

    /**
     * Modifies an employee's salary; invoked by modifyEmployee()
     * @param empl instance of Employee
     */
    private void modifySalary(Employee empl) {
        System.out.println("Enter the modified salary: ");
        double salary = validateDouble();
        empl.setSalary(salary);
    }

    /**
     * Modifies an employee's start date; invoked by modifyEmployee()
     * @param empl instance of Employee
     */
    private void modifyStartDate(Employee empl) {
        LocalDate modDate = validateDate();
        empl.setStartDate(modDate);
    }

    /**
     * Adds an employee object to the ArrayList<Employee> at the user specified index position provided it is within
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

    /**
     * Invokes methods to calculate and print to console the average duration of service and average salary of employees
     * provided employees array is not empty.
     */
    public void avg() {
        int totEmploy = employees.size();
        if (totEmploy == 0) {
            System.out.println("There are no registered employees.");
        } else {
            avgDuration(totEmploy);
            avgSalary(totEmploy);
        }
    }

    /**
     * Calculates and prints to console the average length of service of employees in days.
     */
    private void avgDuration(int totEmploy) {
        long days = 0;
        LocalDate currDate = LocalDate.now();

        for (Employee empl : employees) {
            days += ChronoUnit.DAYS.between(empl.getStartDate(),currDate);
        }
        System.out.println("Average number of days service: " + (days / totEmploy));
    }

    /**
     * Calculates and prints to console the average salary of employees.
     */
    private void avgSalary(int totEmploy) {
        int totSalary = 0;

        for (Employee empl : employees) {
                totSalary += empl.getSalary();
        }
        System.out.println("Average salary: " + (totSalary / totEmploy));
    }

    /**
     * Prints to console the details of the longest serving employee invoking overridden Comparator compare() method.
     */
    private void longestServingEmployee() {
        employees.sort(new DateComparator());
        System.out.println("The longest serving employee is:\n" + employees.get(0));
    }

    /**
     * Prints to console the employee object whose salary is the lowest.
     */
    private void lowestPaidEmployee() {
        Collections.sort(employees);

        System.out.println("The employee with the lowest salary is:\n" + employees.get(0));
    }

    /**
     * Exits programme and notify user
     * @return exit boolean
     */
    private boolean exitProg() {
        boolean exit = true;
        System.out.println("Exiting the programme.");
        return exit;
    }
}
