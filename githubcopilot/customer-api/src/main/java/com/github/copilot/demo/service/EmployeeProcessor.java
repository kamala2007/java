package com.github.copilot.demo.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EmployeeProcessor {

    private final List<Employee> employees;

    public EmployeeProcessor(List<Employee> employees) {
        this.employees = employees != null ? employees : new ArrayList<>();
    }

    public double calculateBonus(Employee employee) {
        if (employee == null) {
            return 0.0;
        }

        double bonus = 0.0;
        switch (employee.getRole()) {
            case "MANAGER":
                bonus = employee.getSalary() * 0.10;
                break;
            case "DEVELOPER":
                bonus = employee.getSalary() * 0.07;
                break;
            case "INTERN":
                bonus = employee.getSalary() * 0.03;
                break;
            default:
                bonus = 0.0;
                break;
        }
        return bonus;
    }

    public void printEmployees() {
        employees.forEach(new java.util.function.Consumer<Employee>() {
            @Override
            public void accept(Employee e) {
                System.out.println(e.getName() + " - " + e.getRole());
            }
        });
    }

    public static class Employee {
        private final String name;
        private final String role;
        private final double salary;

        public Employee(String name, String role, double salary) {
            this.name = Objects.requireNonNull(name);
            this.role = Objects.requireNonNull(role);
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public String getRole() {
            return role;
        }

        public double getSalary() {
            return salary;
        }
    }
}

