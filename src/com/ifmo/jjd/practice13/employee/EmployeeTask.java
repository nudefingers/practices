package com.ifmo.jjd.practice13.employee;

import java.util.*;

public class EmployeeTask {
    public static void main(String[] args) {
        List<Employee> employees = Employee.employeeGenerator(5);
        System.out.println("unsort: " + employees);
        // Дописать метод employeeGenerator и
        // отсортировать его по:
        // имени
        Comparator<Employee> byName = new Employee.NameComparator();
        TreeSet<Employee> employeesByName = new TreeSet<>(byName);
        employeesByName.addAll(employees);
        System.out.println("by name: " + employeesByName);

        // имени и зарплате
        Comparator<Employee> byNameSalary = new Employee.NameComparator()
                .thenComparing(new Employee.SalaryComparator());
        TreeSet<Employee> employeesByNameSalary = new TreeSet<>(byNameSalary);
        employeesByNameSalary.addAll(employees);
        System.out.println("by name, salary: " + employeesByNameSalary);

        // имени, зарплате, возрасту и компании
        Comparator<Employee> byNameSalaryAgeCompany = new Employee.NameComparator()
                .thenComparing(new Employee.SalaryComparator()
                        .thenComparing(new Employee.AgeComparator()
                                .thenComparing(new Employee.CompanyComparator())));
        TreeSet<Employee> employeesByNameSalaryAgeCompany = new TreeSet<>(byNameSalaryAgeCompany);
        employeesByNameSalaryAgeCompany.addAll(employees);
        System.out.println("by name, salary, age, company: " + employeesByNameSalaryAgeCompany);

        /*unsort: [{Max', Apple', 205, 41}, {Elizabeth', Apple', 644, 23}, {Peter', IBM', 608, 22}, {Jack', Apple', 542, 35}, {Peter', IBM', 6, 30}]
        by name: [{Elizabeth', Apple', 644, 23}, {Jack', Apple', 542, 35}, {Max', Apple', 205, 41}, {Peter', IBM', 608, 22}]
        by name, salary: [{Elizabeth', Apple', 644, 23}, {Jack', Apple', 542, 35}, {Max', Apple', 205, 41}, {Peter', IBM', 6, 30}, {Peter', IBM', 608, 22}]
        by name, salary, age, company: [{Elizabeth', Apple', 644, 23}, {Jack', Apple', 542, 35}, {Max', Apple', 205, 41}, {Peter', IBM', 6, 30}, {Peter', IBM', 608, 22}]*/

    }
}
