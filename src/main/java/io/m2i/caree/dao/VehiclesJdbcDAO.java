package io.m2i.caree.dao;

import io.m2i.caree.models.Vehicle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehiclesJdbcDAO implements VehiclesDAO {

    private Vehicle mapToVehicle(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        float price = resultSet.getFloat("price");
        //TODO : Category as a Category object or an id ?
        String description = resultSet.getString("description");
        String imgUrl = resultSet.getString("imgUrl");

        return new Vehicle(id, name, price, description, imgUrl);
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
        String sqlQuery = "SELECT id, name, price, description, imgUrl FROM Vehicles";

        try {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {
                Vehicle vehicle = mapToVehicle(resultSet);
                vehiclesList.add(vehicle);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to gather VehiclesList from database");
        }

        return vehiclesList;
    }

    @Override
    public Vehicle getById(Integer integer) {
        return null;
    }

    @Override
    public void update(Vehicle entity) {
        throw new RuntimeException("");
    }

    @Override
    public void delete(Vehicle entity) {
        throw new RuntimeException("");
    }
}
