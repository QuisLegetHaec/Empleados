package domain;

import java.time.LocalDate;
import java.util.Comparator;

/**
 * Employee defines states of employees and maintains an array list of those registered.
 */
public class Employee implements Comparable<Employee>, Comparator<Employee> {

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

    /**
     * Overridden to print to console the Employee object´s attributes
     * @return instance of employee object
     */
    @Override
    public String toString() {
        return "[name: " + name + "; salary: " + salary + "; start date: " + startDate + "]";
    }

    /**
     * Overridden to sort the employees by salary in ascending order.
     * @param empl Object employee
     * @return int according to sorting
     */
    @Override
    public int compareTo(Employee empl) {           //Note: probably best to do this as a comparator, but to practice have overidden the compareTo method
          if (salary < empl.salary) {
              return - 1;
          }
          if (salary > empl.salary) {
              return 1;
          }
          return 0;
    }

    @Override
    public int compare(Employee o1, Employee o2) {
        if (o1.startDate.isBefore(o2.startDate)) { return -1; }
        if (o1.startDate.isAfter(o2.startDate)) { return 1; }

        return 0;
    }
}
