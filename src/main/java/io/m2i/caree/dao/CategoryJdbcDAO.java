package io.m2i.caree.dao;

import io.m2i.caree.models.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryJdbcDAO implements CategoryDAO {

    private Category mapToCategory(ResultSet resultSet) throws SQLException {

        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");

        return new Category(id, name);
    }

    @Override
    public void create(Category category) {

        Connection connection = ConnectionManager.getInstance();
        String sqlQuery =
                "INSERT INTO Categories(name) VALUES(?)";

        try {

            PreparedStatement prepStatement = connection.prepareStatement(sqlQuery);
            prepStatement.setString(1, category.getName());

            int affectedRows = prepStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to create Category");
        }

    }

    @Override
    public List<Category> findAll() {
        List<Category> categoryList = new ArrayList<>();
        Connection connection = ConnectionManager.getInstance();
        String sqlQuery = "SELECT id, name FROM Categories";

        try {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {
                Category category = mapToCategory(resultSet);
                categoryList.add(category);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to gather categoryList from database");
        }

        return categoryList;
    }

    @Override
    public Category getById(Integer id) {

        Connection connection = ConnectionManager.getInstance();
        String sqlQuery = "SELECT id, name FROM Categories WHERE id=?;";
        Category categoryFound = null;

        try {
            PreparedStatement prepStatement = connection.prepareStatement(sqlQuery);
            prepStatement.setInt(1, id);
            ResultSet result = prepStatement.executeQuery();

            if (result.next()) {
                categoryFound = mapToCategory(result);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return categoryFound;
    }

    @Override
    public void update(Category category) {

        Connection connection = ConnectionManager.getInstance();
        String sqlQuery = "UPDATE Categories " +
                "SET " +
                "name = ? " +
                "WHERE id=?";

        try {
            PreparedStatement prepStatement = connection.prepareStatement(sqlQuery);

            prepStatement.setString(1, category.getName());
            prepStatement.setInt(2, category.getId());

            int row = prepStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to update Category");
        }
    }

    @Override
    public void delete(Category category) {

        Connection connection = ConnectionManager.getInstance();
        String sqlQuery = "DELETE FROM Categories WHERE id=?";

        try {
            PreparedStatement prepStatement = connection.prepareStatement(sqlQuery);
            prepStatement.setInt(1, category.getId());

            int row = prepStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to delete Category");
        }

    }
}
