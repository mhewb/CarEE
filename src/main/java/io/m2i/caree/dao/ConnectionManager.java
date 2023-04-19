package io.m2i.caree.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private static final String URL_DATABASE = "jdbc:mysql://localhost:3306/caree";
    private static final String USER = "root";
    private static String PASSWORD = "MySQL-r00t!";

    private static Connection INSTANCE;

    private ConnectionManager() {
        // This avoids the instantiation : singleton design pattern
    }

    public static Connection getInstance() {
        if (INSTANCE == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                INSTANCE = DriverManager.getConnection(URL_DATABASE, USER, PASSWORD);
            } catch (SQLException e) {
                System.err.println("Error during getConnection");
                e.printStackTrace();
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                System.err.println("Error during driver loading");
                throw new RuntimeException(e);
            }
        }
        return INSTANCE;
    }

    //TODO: implements using Servlets Listeners
    public static void closeConnection() throws SQLException {
        if (INSTANCE != null && !INSTANCE.isClosed()) {
            INSTANCE.close();
        }
    }

}
