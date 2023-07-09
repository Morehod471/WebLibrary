package ru.skypro.lessons.springboot.weblibrary.repository;

import org.springframework.stereotype.Repository;
import ru.skypro.lessons.springboot.weblibrary.pojo.Employee;

import java.util.List;

@Repository
public class EmployeeRepository {

    private final List<Employee> employeeList = List.of(
            new Employee(1,"Катя", 90_000),
            new Employee(2,"Дима", 102_000),
            new Employee(3,"Олег", 80_000),
            new Employee(4,"Вика", 165_000));

    public List<Employee> getAllEmployees() {
        return employeeList;
    }
}