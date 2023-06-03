package com.timgapps.project1.util;

import com.timgapps.project1.dao.PersonDAO;
import com.timgapps.project1.models.Person;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
// т.к. ФИО уникальное, нужен валидатор

//@Component
//public class PersonValidator implements Validator {
//
//    private final PersonDAO personDAO;
//
//    public PersonValidator(PersonDAO personDAO) {
//        this.personDAO = personDAO;
//    }
//
//    @Override
//    public boolean supports(Class<?> aClass) {
//        return Person.class.equals(aClass);
//    }
//
//    @Override
//    public void validate(Object o, Errors errors) {
//        Person person = (Person) o;
//
////        if (personDAO.getPersonByFullName(person.getFullName()).isPresent())
////            errors.rejectValue("fullName", "", "Человек с таким именем уже существует!");
////    }
//}
