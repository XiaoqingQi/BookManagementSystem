package com.qxq.myapp.Controller;

import com.qxq.myapp.Entity.Book;
import com.qxq.myapp.Service.BookService;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/books")
public class Controller {
    @Autowired
    BookService bookService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Book> getAllBooks(){
        Collection<Book> books = bookService.getAllBooks();
        return bookService.getAllBooks();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Book getBookById(@PathVariable("id") int id){
        return bookService.getBookById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addBook(@RequestBody Book book){
        bookService.addBook(book);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteBookById(@PathVariable("id") int id){
        bookService.deleteBookById(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateBook(@RequestBody Book book){
        bookService.updateBook(book);
    }
}
