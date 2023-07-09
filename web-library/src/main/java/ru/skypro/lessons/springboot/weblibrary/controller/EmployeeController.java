package ru.skypro.lessons.springboot.weblibrary.controller;

import org.springframework.web.bind.annotation.*;
import ru.skypro.lessons.springboot.weblibrary.dto.EmployeeDto;
import ru.skypro.lessons.springboot.weblibrary.model.Employee;
import ru.skypro.lessons.springboot.weblibrary.projections.EmployeeFullInfo;
import ru.skypro.lessons.springboot.weblibrary.service.EmployeeService;
import ru.skypro.lessons.springboot.weblibrary.service.EmployeeServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<EmployeeDto> findEmployee() {
        return employeeService.getEmployees();
    }

    @GetMapping("/salary/sum")
    public Integer findSalary() {
        return employeeService.findSalary();
    }

    @GetMapping("/salary/min")
    public List<EmployeeDto> findSalaryMin() {
        return employeeService.findSalaryMin();

    }

    @GetMapping("/salary/max")
    public List<EmployeeDto> findSalaryMax() {
        return employeeService.findSalaryMax();
    }

    @GetMapping("/high-salary")
    public List<EmployeeDto> findSalaryHigh() {
        return employeeService.findSalaryHigh();
    }

    @GetMapping("/salaryHigherThan")
    public List<EmployeeDto> findEmployeeWithSalaryMoreAverage(@RequestParam Integer salary) {
        return employeeService.getEmployeesWithSalaryHigherThan(salary);
    }

    @PostMapping
    public void addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }

    @PutMapping("{id}")
    public void editEmployee(@RequestBody int id) {
        employeeService.editEmployee(id);
    }

    @GetMapping("{id}")
    public List<EmployeeDto> getEmployeesByIdWithRequired(@PathVariable int id) {
        return employeeService.getEmployeesByIdWithRequired(id);
    }

    @DeleteMapping("{id}")
    public void deleteEmployeesWithId(@PathVariable int id) {
        employeeService.deleteEmployeesWithId(id);
    }

    @GetMapping("fullInfo")
    public List<EmployeeFullInfo> getEmployeesFull(int id) {
        return employeeService.getEmployeesFull(id);
    }

    @GetMapping("/paging/page")
    public List<EmployeeDto> getEmployeesWithPaging(@RequestParam("page") int page) {
        return employeeService.getEmployeesWithPaging(page, 10);
    }

    @GetMapping("/withHighestSalary")
    public List<EmployeeFullInfo> withHighestSalary() {
        return employeeService.withHighestSalary();
    }

    @GetMapping("position")
    public List<EmployeeFullInfo> getEmployeesFullPosition(@RequestParam(required = false) String position) {
        return employeeService.getEmployeesFullPosition(position);
    }
}