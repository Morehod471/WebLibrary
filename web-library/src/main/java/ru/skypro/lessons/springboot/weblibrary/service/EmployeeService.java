package ru.skypro.lessons.springboot.weblibrary.service;


import io.micrometer.common.lang.Nullable;
import org.springframework.web.bind.annotation.RequestBody;
import ru.skypro.lessons.springboot.weblibrary.dto.EmployeeDto;
import ru.skypro.lessons.springboot.weblibrary.model.Employee;
import ru.skypro.lessons.springboot.weblibrary.projections.EmployeeFullInfo;
import ru.skypro.lessons.springboot.weblibrary.repository.EmployeeRepository;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDto> getAllEmployees();

    List<EmployeeDto> getEmployees();

    public Integer findSalary();

    public List<EmployeeDto> findSalaryMin();

    public List<EmployeeDto> findSalaryMax();

    public List<EmployeeDto> findSalaryHigh();

    public List<EmployeeDto> getEmployeesWithSalaryHigherThan(Integer salary);

    public List<EmployeeDto> getEmployeesByIdWithRequired(Integer id);

    public void addEmployee(@RequestBody Employee employee);

    public void editEmployee(@RequestBody int id);

    void deleteEmployeesWithId(Integer id);

    List<EmployeeDto> findByIdGreaterThan(int number);

    List<EmployeeFullInfo> getEmployeesFull(int id);

    List<EmployeeFullInfo> getEmployeesFullPosition(@Nullable String position);

    List<EmployeeFullInfo> withHighestSalary();

    List<EmployeeDto> getEmployeesWithPaging(int page, int size);
}
