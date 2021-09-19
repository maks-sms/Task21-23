package com.manegerbdcity;

import java.sql.*;
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
            System.out.println("ВВедите название города что бы добавить его в базу (или пустую строку для выхода): ");
            String str = scan.nextLine();
            if (str.isEmpty()) {
                System.out.println();
                break;
            }
            System.out.println("ВВедите название города что бы добавить его в базу (или пустую строку для выхода): ");
            int str1 = scan.nextInt();
            scan.skip("\\R");

            CitiesService.addCity(new City(str),str1);
        }

    }

    public static void printCity() throws SQLException {
        CitiesService.getCities();
    }

    public static void addBD() throws SQLException {
        Connection connection = DriverManager.getConnection(CitiesService.urlBD);
        Statement statement = connection.createStatement();

        String SQL = "CREATE TABLE IF NOT EXISTS cities (id text, name text)";
        statement.executeUpdate(SQL);
        String SQL1 = "CREATE TABLE IF NOT EXISTS city_details (city_id text, population INTEGER)";
        statement.executeUpdate(SQL1);

        statement.close();
        connection.close();
    }
}
