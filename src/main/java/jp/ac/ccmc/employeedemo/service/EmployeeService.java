package jp.ac.ccmc.employeedemo.service;

import jp.ac.ccmc.employeedemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    //get all employee
    List<Employee> getAll();

    //get employee by id
    Employee getEmployeeById(Long id);

    //create employee
    Employee createEmployee(Employee employee);

    //update employee
    Employee updateEmployee(Long id, Employee employeeEdit);

    //delete employee
    boolean deleteEmployee(Long employeeId);
}
