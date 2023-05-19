package com.example.jdbc_hw2.dao;

import com.example.jdbc_hw2.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeDAOImpl implements EmployeeDAO {
    private final JdbcTemplate jdbcTemplate;


    @Autowired
    public EmployeeDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //Создание(добавление) сущности Employee в таблицу
    @Override
    public Employee addEmployee(Employee employee) {
        jdbcTemplate.update("INSERT INTO Employee (first_name, last_name, gender, age, city_id) " +
                        "VALUES (?,?,?,?,?)", employee.getFirst_name(), employee.getLast_name(), employee.getGender(),
                employee.getAge(), employee.getCity_id());
        return employee;
    }

    //Получение конкретного объекта Employee по id
    public Employee findById(Integer id) {
        return jdbcTemplate.query("SELECT * FROM Employee WHERE id = ?",
                new Object[]{id}, new EmployeeMapper()).stream().findAny().orElse(null);
    }

    //Получение списка всех объектов Employee из базы
    @Override
    public List<Employee> getAllEmployee() {
        return jdbcTemplate.query("SELECT * FROM Employee", new EmployeeMapper());
    }

    //Изменение конкретного объекта Employee в базе по id
    @Override
    public Employee editEmployee(Integer id, Employee employee) {
        jdbcTemplate.update("UPDATE Employee SET first_name = ?, " +
                        "last_name = ?, gender = ?, age = ?, city_id= ? WHERE id = ?",
                employee.getLast_name(), employee.getFirst_name(), employee.getGender(),
                employee.getAge(), employee.getCity_id(), id);
        return employee;
    }

    //Удаление конкретного объекта Employee из базы по id
    @Override
    public Boolean deleteId(Integer id) {
        jdbcTemplate.update("DELETE FROM Application WHERE id=?", id);
        return true;
    }


}
