package com.company.library.dao;

import com.company.library.dao.interfaces.AuthorDao;
import com.company.library.model.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorDaoDatabase implements AuthorDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<Author> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Author> authorList = session.createQuery("FROM Author").list();

        return authorList;
    }

    @Override
    public Author getById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Author author = (Author) session.get(Author.class, id);

        return author;
    }

    @Override
    public void add(Author model) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(model);
    }

    @Override
    public void update(Author model) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(model);
    }

    @Override
    public void delete(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Author author = (Author) session.get(Author.class, id);

        if(author != null){
            session.delete(author);
        }
    }
}
