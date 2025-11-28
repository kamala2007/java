package com.github.copilot.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.SequencedCollection;

public class EmployeeProcessor {

    private final SequencedCollection<Employee> employees;

    public EmployeeProcessor(List<Employee> employees) {
        this.employees = employees != null ? new ArrayList<>(employees) : new ArrayList<>();
    }

    // Java 21: Pattern matching for switch
    public double calculateBonus(Employee employee) {
        if (employee == null) {
            return 0.0;
        }
        return switch (employee.role()) {
            case "MANAGER" -> employee.salary() * 0.10;
            case "DEVELOPER" -> employee.salary() * 0.07;
            case "INTERN" -> employee.salary() * 0.03;
            default -> 0.0;
        };
    }

    public void printEmployees() {
        employees.forEach(e -> System.out.println(e.name() + " - " + e.role()));
    }

    public record Employee(String name, String role, double salary) {
        public Employee {
            Objects.requireNonNull(name);
            Objects.requireNonNull(role);
        }
    }
}
