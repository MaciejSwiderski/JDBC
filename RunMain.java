package com.sda.exercise;

import com.sda.jdbc.DBConnector;

import java.sql.*;
import java.util.Scanner;

public class RunMain {

    public static void main(String[] args) throws SQLException {

        System.out.println("Choose from the menu below:\n" +
                "1. Add client\n2. Display client\n3. Edit client");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        Connection connection = DBConnectorNew.getConnection();
        Statement statement = connection.createStatement();
        DBFunctions dbFunctions = new DBFunctions();

        switch (number) {
            case 1:
                dbFunctions.addNewClient(connection);
                break;
            case 2:
                dbFunctions.showDB();
                break;
            case 3:
                System.out.println("what do you want to update?\n" +
                        "1. first name\n2. last name\n3. address\n4. postal code");
                int number1 = scanner.nextInt();
                dbFunctions.updateClient(number1,statement);
                break;
            default:
                System.out.println("You have not chosen anything from the list above");
        }
    }
}
