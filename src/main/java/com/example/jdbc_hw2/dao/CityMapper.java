package com.example.jdbc_hw2.dao;

import com.example.jdbc_hw2.model.City;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CityMapper implements RowMapper<City> {
    @Override
    public City mapRow(ResultSet rs, int rowNum) throws SQLException {
        int city_id = rs.getInt("city_id");
        String city_name = rs.getString("city_name");
        return new City(city_id, city_name);
    }
}
