package com.arsiu.model.presistent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
    private static final String PATH = "src//main//resources//application.properties";
    private static String url;
    private static String root;
    private static String pass;
    private static Connection connection = null;

    public static Connection setConnection() {
        if (connection == null) {
            try {
                getProperties();
                connection = DriverManager.getConnection(url, root, pass);
            } catch (SQLException e) {
                System.out.println("SQL Exception:" + e.getMessage());
                System.out.println("SQL State:" + e.getSQLState());
                System.out.println("Vendor Error:" + e.getErrorCode());
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("SQL Exception:" + e.getMessage());
                System.out.println("SQL State:" + e.getSQLState());
                System.out.println("Vendor Error:" + e.getErrorCode());
            }
        }
    }

    private static void getProperties() {
        Properties prop = new Properties();
        try (FileInputStream fis = new FileInputStream(PATH)) {
            prop.load(fis);
            url = prop.getProperty("datasource.url");
            root = prop.getProperty("datasource.username");
            pass = prop.getProperty("datasource.password");
            Class.forName(prop.getProperty("datasource.driver-class-name"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
