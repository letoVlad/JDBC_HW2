package com.example.jdbc_hw2.dao;

import com.example.jdbc_hw2.model.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements RowMapper<Employee>  {
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        int id = rs.getInt("id");
        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");
        String gender = rs.getString("gender");
        int age = rs.getInt("age");
        int city_id = rs.getInt("city_id");
        return new Employee(id, firstName, lastName, gender, age, city_id);
    }
}
