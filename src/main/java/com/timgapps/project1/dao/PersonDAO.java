package com.timgapps.project1.dao;

import com.timgapps.project1.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.List;

// содержит всю логику работы с базой данных для модели Person
@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;  // для взамиодействия с БД

    private static Connection connection; // необходимо получить connection, чтобы с его помощью работать с данными из базы данных

//    static {
//        try {
//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
//    public PersonDAO(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }


    // возвращает список, который мы отобразим в браузере
    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
        // RowMapper  - такой объект, который отображает строки из таблицы в наши сущности. Т.е. RowMapper каждую строку таблицы Person отобразит в объект Person()
        // этот RowMapper мы должны реализовать сами (PersonMapper)

//        List<Person> people = new ArrayList<>();
//        try {
//            Statement statement = connection.createStatement();
//            String SQL = "SELECT * FROM Person";
//            ResultSet resultSet = statement.executeQuery(SQL);
//
//            while (resultSet.next()) {
//                Person person = new Person();
//
//                person.setId(resultSet.getInt("id"));
//                person.setFullName(resultSet.getString("name"));
//                person.setYearOfBirth(resultSet.getInt("yearofbirth"));
//
//                people.add(person);
//            }
//        } catch (
//                SQLException e) {
//            e.printStackTrace();
//        }
//        return people;
    }

    public Person show(int id) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class)).stream().findAny().orElse(null);

//        Person person = null;
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Person WHERE id=?");
//            preparedStatement.setInt(1, id);
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            resultSet.next();
//            person = new Person();
//
//            person.setId(resultSet.getInt("id"));
//            person.setFullName(resultSet.getString("name"));
//            person.setYearOfBirth(resultSet.getInt("yearofbirth"));
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
////        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
//        return person;
    }


    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO Person VALUES(1,?,?)", person.getFullName(), person.getYearOfBirth());
//        try {
//
//            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Person VALUES(?,?)");
//
//            preparedStatement.setString(1, person.getFullName());
//            preparedStatement.setInt(2, person.getYearOfBirth());
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        people.add(person);
    }

    public void update(int id, Person person) {
        jdbcTemplate.update("UPDATE Person SET fullName=?, yearofbirth=? WHERE id=?", person.getFullName(), person.getYearOfBirth(), id);


//        PreparedStatement preparedStatement = null;
//        try {
//            preparedStatement = connection.prepareStatement("UPDATE Person SET name=?, yearofbirth=? WHERE id=?");
//            preparedStatement.setString(1, person.getFullName());
//            preparedStatement.setInt(2, person.getYearOfBirth());
//            preparedStatement.setInt(3, id);
//
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

//        Person personToBeUpdated = show(id);
//        personToBeUpdated.setId(person.getId());
//        personToBeUpdated.setName(person.getName());
//        personToBeUpdated.setYearOfBirth(person.getYearOfBirth());
    }

    public void delete(int id) {
//        people.removeIf(p -> p.getId() ==id);
        jdbcTemplate.update("DELETE FROM Person WHERE id=?", id);

//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Peroson WHERE id=?");
//            preparedStatement.setInt(1, id);
//            preparedStatement.executeUpdate();
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
    }

    public Object getBooksByPersonId(int id) {
        return null;
    }
}
