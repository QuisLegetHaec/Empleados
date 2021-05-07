package com.philippabather.empleados;

import java.util.Scanner;

import static com.philippabather.empleados.ValidationUtils.validateInt;

/**
 * Menu class displays menu interface to the user in the console.
 */
public class Menu {

    //declare instance fields
    Scanner input = new Scanner(System.in);

    public void executeMenu() {
        boolean exit = false;

        do {

            System.out.println("###################################################################");
            System.out.println("\n                          Employees                             ");
            System.out.println("\n------------------------------------------------------------------");
            System.out.println("1. Show all employees");
            System.out.println("2. Delete an employee");
            System.out.println("3. Check employee according to index number");
            System.out.println("4. Modify employee details");
            System.out.println("5. Add employee at specified index");
            System.out.println("6. Show average length of service");
            System.out.println("7. Show longest serving employee details");
            System.out.println("8. Show lowest paid employee details");
            System.out.println("9. Exit");

            System.out.println("Choose option: ");
            int option = validateInt();


            switch (option) {
                case 1:
                    showEmployees();
                    break;
                case 2:
                    deleteEmployee();
                    break;
                case 3:
                    checkListPos();
                    break;
                case 4:
                    modifyEmployee();
                    break;
                case 5:
                    insertSpecPos();
                    break;
                case 6:
                    avgDuration();
                    break;
                case 7:
                    longestServingEmployee();
                    break;
                case 8:
                    lowestPaidEmployee();
                    break;
                case 9:
                    exit = exitProg();
                    break;
                default:
                    System.out.println("Choice not recognised.\n");
            }

        } while (!exit);
    }
    private void showEmployees() {}

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
