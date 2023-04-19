package io.m2i.caree.dao;

import io.m2i.caree.models.User;

public interface UserDAO extends GenericDAO<User, Integer> {

    User findByUsername(String username);

}
