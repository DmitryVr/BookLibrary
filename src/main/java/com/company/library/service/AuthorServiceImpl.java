package com.company.library.service;

import com.company.library.dao.interfaces.AuthorDao;
import com.company.library.model.Author;
import com.company.library.service.interfaces.AuthorService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private static final Logger log = Logger.getLogger(AuthorServiceImpl.class);

    @Autowired
    private AuthorDao authorDaoDatabase;

    @Override
    @Transactional
    public List<Author> getAll() {
        log.info("List<Author> getAll()");
        return authorDaoDatabase.getAll();
    }

    @Override
    @Transactional
    public Author getById(int id) {
        log.info("Author getById(int " + id + ")");
        return authorDaoDatabase.getById(id);
    }

    @Override
    @Transactional
    public void update(Author model) {
        log.info("void update(Author " + model +")");
        authorDaoDatabase.update(model);
    }
}
