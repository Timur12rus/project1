package com.timgapps.project1.dao;

import com.timgapps.project1.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

// содержит всю логику работы с базой данных для модели Person
@Component
public class PersonDAO {

    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Ivanov Ivan", 1992));
        people.add(new Person(++PEOPLE_COUNT, "Mikhail Sidorov", 1987));
        people.add(new Person(++PEOPLE_COUNT, "Zaur Tregulov", 1990));
        people.add(new Person(++PEOPLE_COUNT, "Lena Zvereva", 1996));
    }


    // возвращает список, который мы отобразим в браузере
    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }


    public void save(Person person) {
        people.add(person);
    }
}
