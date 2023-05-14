package com.timgapps.project1.models;

public class Person {
    private int id;

    public int getId() {
        return id;
    }

    private String name;

    private int yearOfBirth;

    public Person(int id, String name, int yearOfBirth) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }
}
