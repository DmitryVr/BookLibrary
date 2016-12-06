package com.company.library.dao;

import com.company.library.dao.interfaces.GenreDao;
import com.company.library.model.Genre;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GenreDaoDatabase implements GenreDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<Genre> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Genre> genreList = session.createQuery("FROM Genre").list();

        return genreList;
    }

    @Override
    public Genre getById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Genre genre = (Genre) session.get(Genre.class, id);

        return genre;
    }

    @Override
    public void add(Genre model) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(model);
    }

    @Override
    public void update(Genre model) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(model);
    }

    @Override
    public void delete(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Genre genre = (Genre) session.get(Genre.class, id);

        if(genre != null){
            session.delete(genre);
        }
    }
}
