package io.m2i.caree.dao;

import io.m2i.caree.models.Category;
import io.m2i.caree.models.Vehicle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehiclesJdbcDAO implements VehiclesDAO {

    private Vehicle mapToVehicle(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        float price = resultSet.getFloat("price");
        int idCategory = resultSet.getInt("id_category");
        String description = resultSet.getString("description");
        String imgUrl = resultSet.getString("imgUrl");

        CategoryDAO categoryDAO = new CategoryJdbcDAO();
        Category category = categoryDAO.getById(idCategory);

        return new Vehicle(id, name, category, price, description, imgUrl);
    }

    @Override
    public void create(Vehicle vehicle) {
        Connection connection = ConnectionManager.getInstance();
        String sqlQuery =
                "INSERT INTO Vehicles(name, price, description, imgUrl)"
              + " VALUES(?,?,?,?)";

        try {

            PreparedStatement prepStatement = connection.prepareStatement(sqlQuery);
            prepStatement.setString(1, vehicle.getName());
            prepStatement.setFloat(2, vehicle.getPrice());
            prepStatement.setString(3, vehicle.getDescription());
            prepStatement.setString(4, vehicle.getImgUrl());

            int affectedRows = prepStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to create Vehicle");
        }
    }

    @Override
    public List<Vehicle> findAll() {

        List<Vehicle> vehiclesList = new ArrayList<>();
        Connection connection = ConnectionManager.getInstance();
        String sqlQuery = "SELECT id, name, id_category, price, description, imgUrl FROM Vehicles";

        try {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {
                Vehicle vehicle = mapToVehicle(resultSet);
                vehiclesList.add(vehicle);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to gather VehiclesList from database.");
        }

        return vehiclesList;
    }

    @Override
    public Vehicle getById(Integer id) {

            Connection connection = ConnectionManager.getInstance();
            String sqlQuery = "SELECT id, name, id_category, price, description, imgUrl FROM Vehicles WHERE id=?;";
            Vehicle vehicleFound = null;

            try {
                PreparedStatement prepStatement = connection.prepareStatement(sqlQuery);
                prepStatement.setInt(1, id);
                ResultSet result = prepStatement.executeQuery();

                if (result.next()) {
                    vehicleFound = mapToVehicle(result);
                }

            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }

            return vehicleFound;
        }

    //TODO: Update Vehicle
    @Override
    public void update(Vehicle vehicle) {

        Connection connection = ConnectionManager.getInstance();
        String sqlQuery = "UPDATE Vehicles " +
                "SET " +
                "name = ?, " +
                "price = ?, " +
                "description = ?, " +
                "imgUrl = ?, " +
                "id_category = ? " +
                "WHERE id=?";

        try {
            PreparedStatement prepStatement = connection.prepareStatement(sqlQuery);

            prepStatement.setString(1, vehicle.getName());
            prepStatement.setFloat(2, vehicle.getPrice());
            prepStatement.setString(3, vehicle.getDescription());
            prepStatement.setString(4, vehicle.getImgUrl());
            prepStatement.setInt(5, vehicle.getCategory().getId());
            prepStatement.setInt(6, vehicle.getId());

            int row = prepStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to update Vehicle");
        }

    }

    //TODO: Delete Vehicle
    @Override
    public void delete(Vehicle vehicle) {
        Connection connection = ConnectionManager.getInstance();
        String sqlQuery = "DELETE FROM Vehicles WHERE id=?";

        try {
            PreparedStatement prepStatement = connection.prepareStatement(sqlQuery);
            prepStatement.setInt(1, vehicle.getId());

            int row = prepStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to delete Vehicle");
        }
    }
}
