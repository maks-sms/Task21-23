package com.manegerbdcity;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

/**
 * @author Solodovnykov M.S.
 * @version 1.1
 */

public class Main {

    public static void main(String[] args) throws SQLException {
        addBD();
        inputCity();
        printCity();
    }

    public static void inputCity() throws SQLException {

        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("ВВедите нащвание города что бы добавить уго в базу (или пустую строку для выхода): ");
            String str = scan.nextLine().trim();
            if (str.isEmpty()) {
                System.out.println();
                break;
            }
            CitiesService.addCity(new City(str));
        }

    }

    public static void printCity() throws SQLException {
        List<City> cityList = CitiesService.getCities();
        for (City city : cityList) {
            System.out.println(city.toString());
        }
    }

    public static void addBD() throws SQLException {
        Connection connection = DriverManager.getConnection(CitiesService.urlBD);
        Statement statement = connection.createStatement();

        String SQL = "CREATE TABLE IF NOT EXISTS cities (id text, name text)";
        statement.executeUpdate(SQL);

        statement.close();
        connection.close();
    }
}
