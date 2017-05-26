package com.sokolov.javafx.controller.interfaces.impl;

import com.sokolov.javafx.controller.dbConnection.DBConnect;
import com.sokolov.javafx.controller.interfaces.TableDok;
import com.sokolov.javafx.controller.objects.Dok;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TableDokImpl implements TableDok {


    private ObservableList<Dok> dokList =  FXCollections.observableArrayList();

    private Connection connection = null;
    public void create(Dok dok) {

    }

    public void add(Dok dok) {
        dokList.add(dok);
    }

    public void update(Dok dok) {

    }

    public void delete(Dok dok) {
        dokList.remove(dok);
    }


    public ObservableList<Dok> getDokList() {
        return dokList;
    }

    public void setDokList(ObservableList<Dok> dokList) {
        this.dokList = dokList;
    }

    public void fillDataSet(){
        Statement statement = null;
        connection = DBConnect.connection();
        try {

            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT NNDOK,NAME_USER,DATE_ZAP,DATE_OP,TIPDOKG,ID_ORGANIZ FROM GASTELLO.DOK WHERE " +
                    "NNDOK = 566806");

            while (resultSet.next()){
                String nn  = resultSet.getString("NNDOK");
                String name_user  = resultSet.getString("NAME_USER");
                String date_zap  = resultSet.getString("DATE_ZAP");
                String date_op = resultSet.getString("DATE_OP");
                String tipdokg  = resultSet.getString("TIPDOKG");
                String id_organiz = resultSet.getString("ID_ORGANIZ");
                dokList.add(new Dok(nn,name_user,date_zap,date_op,tipdokg,id_organiz));
            }


            System.out.println("data select successful!");

        } catch (SQLException e) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}

