package ru.skypro.lessons.springboot.weblibrary.service;


import org.springframework.web.bind.annotation.RequestBody;
import ru.skypro.lessons.springboot.weblibrary.pojo.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    public Integer findSalary();

    public List<Employee> findSalaryMin();

    public List<Employee> findSalaryMax();

    public List<Employee> findSalaryHigh();

    public List<Employee> findEmployeeByIdWithRequired(Integer id);

    void deleteEmployeesWithId(Integer id);

    void addEmployee(@RequestBody Employee employee);

    void editEmployee(@RequestBody int id);


}
