package com.company.library.service;

import com.company.library.dao.interfaces.BookDao;
import com.company.library.model.Book;
import com.company.library.service.interfaces.BookService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BooksServiceImpl implements BookService {

    private static final Logger log = Logger.getLogger(BooksServiceImpl.class);

    @Autowired
    private BookDao bookDaoDatabase;

    @Override
    @Transactional
    public Book getById(int id) {
        log.info("Book getById(int " + id + ")");
        return bookDaoDatabase.getById(id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        log.info("void delete(int " + id + ")");
        bookDaoDatabase.delete(id);
    }

    @Override
    @Transactional
    public void add(Book model) {
        log.info("void add(Book " + model + ")");
        bookDaoDatabase.add(model);
    }

    @Override
    @Transactional
    public void update(Book model) {
        log.info("void update(Book " + model + ")");
        bookDaoDatabase.update(model);
    }
}
