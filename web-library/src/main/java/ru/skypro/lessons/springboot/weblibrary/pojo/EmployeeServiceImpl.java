package ru.skypro.lessons.springboot.weblibrary.pojo;

import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.weblibrary.repository.EmployeeRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    @Override
    public Integer findSalary() {
        Integer sum = getAllEmployees().stream()
                .map(Employee::getSalary)
                .reduce(0, Integer::sum);
        return sum;
    }

    @Override
    public List<Employee> findSalaryMin() {
        Comparator<Employee> comparator = Comparator.comparing(Employee::getSalary);
        List<Employee> minSalary = getAllEmployees().stream()
                .min(comparator)
                .stream()
                .collect(Collectors.toList());
        return minSalary;
    }

    @Override
    public List<Employee> findSalaryMax() {
        Comparator<Employee> comparator = Comparator.comparing(Employee::getSalary);
        List<Employee> maxSalary = getAllEmployees().stream()
                .max(comparator)
                .stream()
                .collect(Collectors.toList());
        return maxSalary;
    }

    @Override
    public List<Employee> findSalaryHigh() {
        int amount = getAllEmployees().size();
        int avgSalary = findSalary() / amount;
        List<Employee> salaryHigherAvgSalary = getAllEmployees().stream()
                .filter(i -> i.getSalary() >= avgSalary)
                .toList();
        return salaryHigherAvgSalary;
    }

    @Override
    public List<Employee> findEmployeeWithSalaryMoreAverage(Integer salary) {
        List<Employee> salaryEmployeeHigherThenAvgSalary = getAllEmployees().stream()
                .filter(i -> i.getSalary() >= salary)
                .toList();
        return salaryEmployeeHigherThenAvgSalary;
    }

    @Override
    public List<Employee> findEmployeeByIdWithRequired(Integer id) {
        List<Employee> getIdEmployee = getAllEmployees().stream()
                .filter(i -> i.equals(getAllEmployees().get(id)))
                .toList();
        return getIdEmployee;
    }

    @Override
    public void deleteEmployeesWithId(Integer id) {
        getAllEmployees().remove(id);
    }

    @Override
    public void addEmployee(Employee employee) {
        getAllEmployees().add(employee);
    }

    @Override
    public void editEmployee(int id) {
        getAllEmployees().get(id);
    }


}
