package com.timgapps.project1.dao;


import com.timgapps.project1.models.Person;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


//
public class PersonMapper implements RowMapper<Person> {
    @Override
    // � ���� ������ �� resultSet'a �� ������ ����� ��������� ������ � ���������� � � ������ Person
    public Person mapRow(ResultSet resultSet, int i) throws SQLException {
        Person person = new Person();

        person.setId(resultSet.getInt("id"));
        person.setFullName(resultSet.getString("name"));

        return person;
    }
}
