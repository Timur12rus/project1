package com.timgapps.project1.dao;

import com.timgapps.project1.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // возвращает список, который мы отобразим в браузере
    public List<Book> index() {
        return jdbcTemplate.query("SELECT * FROM Book", new BeanPropertyRowMapper<>(Book.class));
    }

    public Book show(int id) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE id=", Object[]{
            id, new BeanPropertyRowMapper<>()
        })
    }

    public void save(Book book) {
        book.setId(++BOOKS_COUNT);
        books.add(book);
    }

    public void update(int id, Book book) {
        Book bookToBeUpdated = show(id);
        bookToBeUpdated.setId(book.getId());
        bookToBeUpdated.setAuthor(book.getAuthor());
        bookToBeUpdated.setTitle(book.getTitle());
        bookToBeUpdated.setYear(book.getYear());
        System.out.println("bookToBeUpdated.getYearOfPublication() = " + bookToBeUpdated.getYear());
    }

    public void delete(int id) {
        books.removeIf(book -> book.getId() == id);
    }
}
