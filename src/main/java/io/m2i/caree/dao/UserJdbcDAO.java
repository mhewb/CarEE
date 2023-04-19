package io.m2i.caree.dao;

import io.m2i.caree.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserJdbcDAO implements UserDAO {

    private User mapToUser(ResultSet resultSet) throws SQLException {

        int id = resultSet.getInt("id");
        String username = resultSet.getString("username");
        String email = resultSet.getString("email");
        String password = resultSet.getString("password");

        return new User(id, username, email, password);

    }

    @Override
    public void create(User user) {

        Connection connection = ConnectionManager.getInstance();
        String sqlQuery = "INSERT INTO Users(username, email, password) VALUES(?,?,?)";

        try {

            PreparedStatement prepStatement = connection.prepareStatement(sqlQuery);
            prepStatement.setString(1, user.getUsername());
            prepStatement.setString(2, user.getEmail());
            prepStatement.setString(3, user.getPassword());

            int row = prepStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to create User.");
        }
    }

    @Override
    public List<User> findAll() {

        List<User> userList = new ArrayList<>();
        Connection connection = ConnectionManager.getInstance();
        String sqlQuery = "SELECT id, username, email, password FROM Users";

        try {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {
                User user = mapToUser(resultSet);
                userList.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to gather UserList from database.");
        }

        return userList;

    }

    @Override
    public User getById(Integer id) {

        Connection connection = ConnectionManager.getInstance();
        String sqlQuery = "SELECT id, username, password, email FROM Users WHERE id=?;";
        User userFound = null;

        try {
            PreparedStatement prepStatement = connection.prepareStatement(sqlQuery);
            prepStatement.setInt(1, id);
            ResultSet result = prepStatement.executeQuery();

            if (result.next()) {
                userFound = mapToUser(result);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return userFound;

    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(User entity) {

    }

    @Override
    public User findByUsername(String username) {
        Connection connection = ConnectionManager.getInstance();
        String query = "SELECT id, username, email, password FROM users WHERE username=?;";
        User userFound = null;

        try {
            PreparedStatement prepStatement = connection.prepareStatement(query);
            prepStatement.setString(1, username);
            ResultSet result = prepStatement.executeQuery();
            if (result.next()) {
                userFound = new User(
                        result.getInt("id"),
                        result.getString("email"),
                        result.getString("username"),
                        result.getString("password")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return userFound;

    }
}
