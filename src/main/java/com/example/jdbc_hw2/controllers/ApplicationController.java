package com.example.jdbc_hw2.controllers;

import com.example.jdbc_hw2.dao.EmployeeDAOImpl;
import com.example.jdbc_hw2.model.Employee;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class ApplicationController {
    private final EmployeeDAOImpl applicationDAO;

    public ApplicationController(EmployeeDAOImpl applicationDAO) {
        this.applicationDAO = applicationDAO;
    }

    @Operation(summary = "Добавить нового сотрудника")
    @PostMapping
    public Employee addNewEmployee(@RequestBody Employee employee) {
        applicationDAO.addEmployee(employee);
        return employee;
    }

    @Operation(summary = "Получить сотрудника")
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable int id) {
        Employee employee = applicationDAO.findById(id);
        return employee != null ? ResponseEntity.ok(employee) : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Удалить сотрудника")
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteIngredients(@PathVariable int id) {
        return applicationDAO.deleteId(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Получить всех сотрудников")
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployee() {
        List<Employee> allEmployee = applicationDAO.getAllEmployee();
        return ResponseEntity.ok(allEmployee);
    }

    @Operation(summary = "Редактировать сотрудника")
    @PutMapping("/{id}")
    public ResponseEntity<Employee> editEmployee(@PathVariable int id, @RequestBody Employee employee) {
        Employee employee1 = applicationDAO.editEmployee(id, employee);
        return employee1 != null ? ResponseEntity.ok(employee1) : ResponseEntity.notFound().build();
    }
}
