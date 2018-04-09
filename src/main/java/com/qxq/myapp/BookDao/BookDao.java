package com.qxq.myapp.BookDao;

import com.qxq.myapp.Entity.Book;

import java.util.Collection;

public interface BookDao {
    Collection<Book> getAllBooks();

    Book getBookById(int id);

    void addBook(Book book);

    void deleteBookById(int id);

    void updateBook(Book book);
}
