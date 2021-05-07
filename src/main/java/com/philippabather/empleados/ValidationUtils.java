package com.philippabather.empleados;

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
                response = Integer.parseInt(sc.next());
                isValid = true;

            } catch (NumberFormatException nfe) {
                System.out.println("The input is invalid.\nEnter a number");
            }
        }
        return response;
    }
}
