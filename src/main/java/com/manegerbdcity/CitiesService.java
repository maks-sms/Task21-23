package com.manegerbdcity;

import java.sql.*;

public class CitiesService {

    static String urlBD = "jdbc:sqlite:C:\\sqlite\\homeworks.db";

    public static void addCity(City city) throws SQLException {

        Connection connection = DriverManager.getConnection(urlBD);
        Statement statement = connection.createStatement();

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO cities (id, name) VALUES (?, ?)");
        preparedStatement.setString(1, city.getId());
        preparedStatement.setString(2, city.getName());
        preparedStatement.executeUpdate();

        statement.close();
        connection.close();
    }

    public static void addCity(City city, int population) throws SQLException {
        Connection connection = DriverManager.getConnection(urlBD);
        Statement statement = connection.createStatement();

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO cities (id, name) VALUES (?, ?)");
        preparedStatement.setString(1, city.getId());
        preparedStatement.setString(2, city.getName());
        preparedStatement.executeUpdate();

        PreparedStatement preparedStatement2 = connection.prepareStatement("INSERT INTO city_details (city_id, population) VALUES (?, ?)");
        preparedStatement2.setString(1, city.getId());
        preparedStatement2.setInt(2, population);
        preparedStatement2.executeUpdate();

        statement.close();
        connection.close();
    }

    public static void getCities() throws SQLException {
        Connection connection = DriverManager.getConnection(urlBD);
        Statement statement = connection.createStatement();

        String SQL = "SELECT cities.name, city_details.population FROM cities JOIN city_details";
        ResultSet resultSet = statement.executeQuery(SQL);

        while (resultSet.next()) {
            String name = resultSet.getString("name");
            int population = resultSet.getInt("population");
            System.out.println(name + " " + population);
        }
        statement.close();
        connection.close();
    }
}
