package com.timgapps.project1.dao;

import com.timgapps.project1.models.Book;
import com.timgapps.project1.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookDAO {
    private static int BOOKS_COUNT;
    private List<Book> books;

    {
        books = new ArrayList<>();
        books.add(new Book(++BOOKS_COUNT, "The prince and the pauper", "Mark Twain", 1992));
        books.add(new Book(++BOOKS_COUNT, "The jungle book", "Redyard Kipling", 1987));
        books.add(new Book(++BOOKS_COUNT, "The wind in the willows", "Kenneth Grehame", 1990));
        books.add(new Book(++BOOKS_COUNT, "Robinson Crusoe", "Daniel Defoe", 1996));
    }

    // возвращает список, который мы отобразим в браузере
    public List<Book> index() {
        return books;
    }

    public Book show(int id) {
        return books.stream().filter(book -> book.getId() == id).findAny().orElse(null);
    }
}