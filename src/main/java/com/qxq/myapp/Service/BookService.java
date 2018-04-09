package com.qxq.myapp.Service;


import com.qxq.myapp.BookDao.BookDao;
import com.qxq.myapp.BookDao.BookDaoImpl;
import com.qxq.myapp.Entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Component
@Service
public class BookService {
    @Autowired
    @Qualifier("MySQL")
    BookDao bookDao;

    public Collection<Book> getAllBooks(){
        return bookDao.getAllBooks();
    }
    public Book getBookById(int id){
        return bookDao.getBookById(id);
    }
    public void addBook(Book book){
        bookDao.addBook(book);
    }
    public void deleteBookById(int id){
        bookDao.deleteBookById(id);
    }
    public void updateBook(Book book){
        bookDao.updateBook(book);
    }
}
