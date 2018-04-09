package com.qxq.myapp.BookDao;

import com.qxq.myapp.Entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
@Repository
@Qualifier("MySQL")
public class BookDaoImpl implements BookDao {
    public Collection<Book> getAllBooks(){
        List<Book> books = new ArrayList<Book>();
        Transaction transaction = null;
        try {
            Session session = SessionInstance.getSession();
            transaction = session.beginTransaction();
            String hql = "FROM Book";
            Query query = session.createQuery(hql);
            List<Book> results = query.list();
            for (Book book : results) {
                books.add(book);
            }
            transaction.commit();
            session.close();
            return books;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return books;
    }
    public Book getBookById(int id){
        Transaction transaction = null;
        try{
            Session session = SessionInstance.getSession();
            transaction = session.beginTransaction();
            String hql = "FROM Book B WHERE B.book_id = :book_id";
            Query query = session.createQuery(hql);
            query.setParameter("book_id",id);
            List<Book> results = query.list();
            transaction.commit();
            session.close();
            if (results.size() == 0){
                return null;
            }
            return results.get(0);
        }catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return null;
    }
    public void addBook(Book book){
        Transaction transaction = null;
        try{
            Session session = SessionInstance.getSession();
            transaction = session.beginTransaction();
            session.save(book);
            transaction.commit();
            session.close();
        } catch (Exception e){
            e.printStackTrace();
            if (transaction != null){
                transaction.rollback();
            }
        }
    }
    public void deleteBookById(int id){
        Transaction transaction = null;
        try{
            Session session = SessionInstance.getSession();
            transaction = session.beginTransaction();
            String hql = "DELETE FROM Book B WHERE B.book_id = :book_id";
            Query query = session.createQuery(hql);
            query.setParameter("book_id",id);
            query.executeUpdate();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
    public void updateBook(Book book){
        Transaction transaction = null;
        try{
            Session session = SessionInstance.getSession();
            transaction = session.beginTransaction();
            String hql = "UPDATE Book set book_name = :book_name, book_author = :book_author, book_number = :book_number" +
                         " WHERE book_id = :book_id";
            Query query = session.createQuery(hql);
            query.setParameter("book_name", book.getBook_name());
            query.setParameter("book_author", book.getBook_author());
            query.setParameter("book_number", book.getBook_number());
            query.setParameter("book_id", book.getBook_id());
            query.executeUpdate();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
