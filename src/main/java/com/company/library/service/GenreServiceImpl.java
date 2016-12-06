package com.company.library.service;

import com.company.library.dao.interfaces.GenreDao;
import com.company.library.model.Genre;
import com.company.library.service.interfaces.GenreService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

    private static final Logger log = Logger.getLogger(GenreServiceImpl.class);

    @Autowired
    private GenreDao genreDaoDatabase;

    @Override
    @Transactional
    public List<Genre> getAll() {
        log.info("List<Genre> getAll()");
        return genreDaoDatabase.getAll();
    }

    @Override
    @Transactional
    public Genre getById(int id) {
        log.info("Genre getById(int " + id + ")");
        return genreDaoDatabase.getById(id);
    }

    @Override
    @Transactional
    public void update(Genre model) {
        log.info("void update(Genre " + model + ")");
        genreDaoDatabase.update(model);
    }
}
