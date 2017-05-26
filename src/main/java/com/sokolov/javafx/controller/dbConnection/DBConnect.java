package com.sokolov.javafx.controller.dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnect {

    public static Connection connection(){
        Connection  con = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@192.168.10.56:1521:ora112";
            String user = "gastello";
            String pass = "gjkysqgbpltw";
            con = DriverManager.getConnection(url, user, pass);

        } catch (ClassNotFoundException e) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, e);
        } catch (SQLException e) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, e);
        }

        return con;
    }
}
