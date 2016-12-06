package com.company.library.dao;

import com.company.library.dao.interfaces.UserDao;
import com.company.library.model.User;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoDatabase implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public User getByUsername(String username) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM User u WHERE u.username=:username");
        query.setParameter("username", username);
        User user = (User) query.uniqueResult();

        return user;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User getById(int id) {
        return null;
    }

    @Override
    public void add(User model) {
    }

    @Override
    public void update(User model) {

    }

    @Override
    public void delete(int id) {

    }
}
