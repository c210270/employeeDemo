package jp.ac.ccmc.employeedemo.service;

import jp.ac.ccmc.employeedemo.entity.Employee;
import jp.ac.ccmc.employeedemo.exception.ResourceNotFoundException;
import jp.ac.ccmc.employeedemo.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceIpl implements EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public List<Employee> getAll() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
         Employee employee = employeeRepo.findById(id).orElseThrow(()->
                 new ResourceNotFoundException("Employee not exist with id :" + id));
         return employee;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepo.save(employee);

    }

    @Override
    public Employee updateEmployee(Long id, Employee employeeEdit) {
        Employee employee= employeeRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id :" + id));
        employee.setName(employeeEdit.getName());
        employee.setEmail(employeeEdit.getEmail());
        employee.setGender(employeeEdit.getGender());
        return employeeRepo.save(employee);

    }

    @Override
    public boolean deleteEmployee(Long id) {

         employeeRepo.deleteById(id);
        return true;
    }
}
