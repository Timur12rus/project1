package com.timgapps.project1.dao;

import com.timgapps.project1.models.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class    BookDAO {
    private static int BOOKS_COUNT;
    private List<Book> books;


    // возвращает список, который мы отобразим в браузере
    public List<Book> index() {
        return books;
    }

    public Book show(int id) {
        return books.stream().filter(book -> book.getId() == id).findAny().orElse(null);
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
