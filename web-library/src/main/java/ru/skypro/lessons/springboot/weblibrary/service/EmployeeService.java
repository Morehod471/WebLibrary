package ru.skypro.lessons.springboot.weblibrary.service;

import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.weblibrary.pojo.Employee;
import ru.skypro.lessons.springboot.weblibrary.repository.EmployeeRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService{

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    public Integer findSalary() {
        Integer sum = getAllEmployees().stream()
                .map(Employee::getSalary)
                .reduce(0, Integer::sum);
        return sum;
    }

    public List<Employee> findSalaryMin() {
        Comparator<Employee> comparator = Comparator.comparing(Employee::getSalary);
        List<Employee> minSalary = getAllEmployees().stream()
                .min(comparator)
                .stream()
                .collect(Collectors.toList());
        return minSalary;
    }

    public List<Employee> findSalaryMax() {
        Comparator<Employee> comparator = Comparator.comparing(Employee::getSalary);
        List<Employee> maxSalary = getAllEmployees().stream()
                .max(comparator)
                .stream()
                .collect(Collectors.toList());
        return maxSalary;
    }

    public List<Employee> findSalaryHigh() {
        int amount = getAllEmployees().size();
        int avgSalary = findSalary() / amount;
        List<Employee> salaryHigherAvgSalary = getAllEmployees().stream()
                .filter(i -> i.getSalary() >= avgSalary)
                .toList();
        return salaryHigherAvgSalary;
    }
}