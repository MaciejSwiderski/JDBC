package com.sda.exercise;
import java.sql.*;
import java.util.Scanner;

public class DBFunctions {

    public static void showDB() throws SQLException {

        String sql = "select * from customer";
        Connection connection = DBConnectorNew.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        System.out.printf("%-10s | %-15s | %-15s | %-15s", "NAME", "SURNAME", "ADDRESS", "POSTAL CODE");
        System.out.println();
        System.out.println("------------------------------------------------------------");
        while (resultSet.next()) {
            System.out.printf("%-10s | %-15s | %-15s | %-15s", resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getString("address"),
                    resultSet.getString("postal_code"));
            System.out.println();
//                    System.out.println("NAME: " + resultSet.getString("first_name")
//                            + ("    SURNAME: " + resultSet.getString("last_name"))
//                            + "     ADDRESS: " + resultSet.getString("address")
//                            + "    POSTAL CODE " + resultSet.getString("postal_code"));
        }
    }

    public static void addNewClient(Connection connection) {
        Scanner scanner = new Scanner(System.in);
        String insert = "insert into customer (first_name, last_name, address, postal_code)values(?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
            System.out.println("podaj first name");
            preparedStatement.setString(1, scanner.next());
            System.out.println("podaj last name");
            preparedStatement.setString(2, scanner.next());
            System.out.println("podaj address");
            preparedStatement.setString(3, scanner.next());
            System.out.println("podaj postal code");
            preparedStatement.setString(4, scanner.next());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateClient(int number1, Statement statement) {
        Scanner scanner = new Scanner(System.in);
        switch (number1) {
            case 1:
                System.out.println("provide new name");
                String newName = scanner.next();
                System.out.println("old name ");
                String oldName = scanner.next();
                String update = "update customer set first_name ='" + newName + "'where first_name ='" + oldName + "';";
                try {
                    statement.executeUpdate(update);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                System.out.println("provide new last name");
                String newLastName = scanner.next();
                System.out.println("provide old last name");
                String oldLastName = scanner.next();
                String updateLastName = "update customer set last_name ='" + newLastName + "'where last_name ='" + oldLastName + "';";
                try {
                    statement.executeUpdate(updateLastName);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                System.out.println("provide new address");
                String newAddress = scanner.next();
                System.out.println("provide old address");
                String oldAddress = scanner.next();
                String updateAddress = "update customer set address ='" + newAddress + "'where address ='" + oldAddress + "';";
                try {
                    statement.executeUpdate(updateAddress);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case 4:
                System.out.println("provide new postal code");
                String newPostalCode = scanner.next();
                System.out.println("provide old postal code");
                String oldPostalCode = scanner.next();
                String updatePostalCode = "update customer set postal_code ='" + newPostalCode + "'where postal_code ='" + oldPostalCode + "';";
                try {
                    statement.executeUpdate(updatePostalCode);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}
