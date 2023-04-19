package io.m2i.caree.services;

import io.m2i.caree.dao.UserDAO;
import io.m2i.caree.dao.UserJdbcDAO;
import io.m2i.caree.models.User;

public class UserService {

    private final UserDAO userDAO = new UserJdbcDAO();
    public boolean checkLog(String username, String password) {
        User userFound = userDAO.findByUsername(username);

        if (userFound != null) {
            return userFound.getPassword().equals(password);
        }
        return false;
    }

}
