package domain;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 * Employee defines states of employees and maintains an array list of those registered.
 */
public class Employee {

    //declare instance variables
    private String name;
    private double salary;
    private LocalDate startDate;

    //constructor

    public Employee(String name, double salary, LocalDate startDate) {
        this.name = name;
        this.salary = salary;
        this.startDate = startDate;
    }

    //getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    //other methods

    @Override
    public String toString() {
        return "[name: " + name + "; salary: " + salary + "; start date: " + startDate + "]";
    }
}
