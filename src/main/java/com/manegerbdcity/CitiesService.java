package com.manegerbdcity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public static List<City> getCities() throws SQLException {

        List<City> cityList = new ArrayList<>();

        Connection connection = DriverManager.getConnection(urlBD);
        Statement statement = connection.createStatement();

        String query = "SELECT * FROM cities";
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            cityList.add(new City(id, name));
        }

        resultSet.close();
        statement.close();
        connection.close();

        return cityList;
    }
}
