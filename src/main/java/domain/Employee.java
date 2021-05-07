package domain;

import java.util.ArrayList;
import java.util.Date;

/**
 * Employee defines states of employees and maintains an array list of those registered.
 */
public class Employee {

    //declare instance variables
    private String name;
    private double salary;
    private Date startDate;
    private ArrayList<Employee> employees;

    //constructor

    public Employee(String name, double salary, Date startDate) {
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    //other methods

    @Override
    public String toString() {
        return "[name: " + name + "; salary: " + salary + "; start date: " + startDate + "]";
    }
}
