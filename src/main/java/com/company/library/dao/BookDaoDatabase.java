package com.company.library.dao;

import com.company.library.dao.interfaces.BookDao;
import com.company.library.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoDatabase implements BookDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<Book> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Book> bookList = session.createQuery("FROM Book").list();

        return bookList;
    }

    @Override
    public Book getById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Book book = (Book) session.get(Book.class, id);

        return book;
    }

    @Override
    public void add(Book model) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(model);
    }

    @Override
    public void update(Book model) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(model);
    }

    @Override
    public void delete(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Book book = (Book) session.get(Book.class, id);

        if(book != null){
            session.delete(book);
        }
    }
}
