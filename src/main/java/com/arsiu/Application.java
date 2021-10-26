package com.arsiu;

import com.arsiu.view.View;

import java.sql.*;

public class Application {
//    private static final String url = "jdbc:mysql://localhost:3306/nova_poshta";
//    private static final String user = "root";
//    private static final String pass = "Zw(8/f,/>SSX";
//
//    private static Connection connection = null;
//    private static Statement statement = null;
//    private static ResultSet rs = null;
    public static void main(String[] args) {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            connection = DriverManager.getConnection(url, user, pass);
//            statement = connection.createStatement();
//        } catch (ClassNotFoundException e){
//            System.out.println("MySQL Driver is not loaded");
//        } catch (SQLException e){
//            System.out.println("SQLException: " + e.getMessage());
//            System.out.println("SQLState: " + e.getSQLState());
//            System.out.println("VendorError: " + e.getErrorCode());
//        } finally {
//            if (rs != null) {
//                try {
//                    rs.close();
//                } catch (SQLException ignored) {}
//            }
//            if (statement != null) {
//                try {
//                    statement.close();
//                } catch (SQLException ignored) {}
//            }
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException ignored) {}
//            }
//        }
        View view = new View();
        view.print();

    }
}
