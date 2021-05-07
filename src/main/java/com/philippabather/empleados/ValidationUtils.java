package com.philippabather.empleados;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class ValidationUtils {

    //declare instance fields
    private static Scanner sc = new Scanner(System.in);


    /**
     * Validates user menu option input.
     * @return int reflecting user's choice
     */
    public static int validateInt() {
        boolean isValid = false;
        int response = -1;

        while(!isValid) {
            try {
                response = Integer.parseInt(sc.nextLine());
                isValid = true;
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid input.\nEnter a number");
            }
        }
        return response;
    }

    public static double validateDouble() {
        boolean isValid = false;
        double response = -1.0;

        while(!isValid) {
            try {
                response = Double.parseDouble(sc.nextLine());
                isValid = true;
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid input.\nEnter a number.");
            }
        }
        return response;
    }

    public static LocalDate validateDate() {
        boolean isValid = false;
        LocalDate dateObj = null;;


        while(!isValid) {
            System.out.println("Enter start year: ");
            String yr = sc.nextLine();
            System.out.println("Enter numerical month: ");
            String mnth = sc.nextLine();
            mnth = checkMonth(mnth);
            System.out.println("Enter day: ");
            String day = sc.nextLine();
            day = checkDay(day);
            String dateStr = yr + "-" + mnth + "-" + day;
            try {
                dateObj = LocalDate.parse(dateStr);
                isValid = true;

            } catch (DateTimeException dte) {
                System.out.println("Invalid input.\nEnter yyyy-MM-dd (e.g.: 2021-01-01): ");
            }

        }
        return dateObj;

    }

    public static String checkMonth(String mnth) {
        if (mnth.length() == 1) {
            mnth = "0" + mnth;
        }
        return mnth;
    }

    public static String checkDay(String day) {
        if (day.length() == 1) {
            day = "0" + day;
        }
        return day;
    }

    public static int validateOption() {
        boolean isValid = false;
        int response = -1;

        while (!isValid) {
            try {
                response = Integer.parseInt(sc.nextLine());
                if (response == 0 || response == 1) {
                    isValid = true;
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Error: input 1 to modify details or 0 to continue");
            }
        }
        return response;
    }

}
