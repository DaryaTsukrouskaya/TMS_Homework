package jaxb;

import Exceptions.EmployeeNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeFounder_SecondVariant {

    public static void employeeFounder(List<Employee> employees, String fullName) {

        try {
            Employee employee = employees.stream().filter(e -> e.getFullName().equals(fullName)).findFirst().orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
            System.out.println(employee);
        } catch (EmployeeNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
}
