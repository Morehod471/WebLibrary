package ru.skypro.lessons.springboot.weblibrary.controller;

import org.springframework.web.bind.annotation.*;
import ru.skypro.lessons.springboot.weblibrary.pojo.Employee;
import ru.skypro.lessons.springboot.weblibrary.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class    EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> findEmployee() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/salary/sum")
    public Integer findSalary() {
        return employeeService.findSalary();
    }

    @GetMapping("/salary/min")
    public List<Employee> findSalaryMin() {
        return employeeService.findSalaryMin();

    }

    @GetMapping("/salary/max")
    public List<Employee> findSalaryMax() {
        return employeeService.findSalaryMax();
    }

    @GetMapping("/high-salary")
    public List<Employee> findSalaryHigh() {
        return employeeService.findSalaryHigh();
    }

    @GetMapping("/salaryHigherThan")
    public List<Employee> findEmployeeWithSalaryMoreAverage(@RequestParam("salary") Integer salary) {
        return employeeService.findSalaryHigh();
    }
}