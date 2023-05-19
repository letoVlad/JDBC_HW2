package com.example.jdbc_hw2.dao;


import com.example.jdbc_hw2.model.Employee;

import java.util.List;

public interface EmployeeDAO {
    Employee addEmployee(Employee employee);
    Employee findById(Integer id);
    Boolean deleteId(Integer id);
    List<Employee> getAllEmployee();
    Employee editEmployee(Integer id, Employee employee);

}
