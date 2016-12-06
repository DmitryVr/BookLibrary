package com.company.library.dao.interfaces;

import com.company.library.model.User;

public interface UserDao extends ItemDao<User> {

    User getByUsername(String username);
}
