package ru.skypro.lessons.springboot.weblibrary.pojo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    public Integer findSalary();

    public List<Employee> findSalaryMin();

    public List<Employee> findSalaryMax();

    public List<Employee> findSalaryHigh();

    public List<Employee> findEmployeeWithSalaryMoreAverage(Integer salary);

    public List<Employee> findEmployeeByIdWithRequired(Integer id);


}
