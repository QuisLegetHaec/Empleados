package com.philippabather.empleados;

import domain.Employee;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConstructorTest {

    @Test
    public void empleadoConstructor() {
        //declare variables
        LocalDate dateObj = LocalDate.parse("2021-01-01");
        Employee emp = new Employee("Pip Squeak", 12.000, dateObj);
        assertEquals("Pip Squeak", emp.getName());
        assertEquals(12.000, emp.getSalary());
        assertEquals(LocalDate.parse("2021-01-01"), emp.getStartDate());
    }
}
