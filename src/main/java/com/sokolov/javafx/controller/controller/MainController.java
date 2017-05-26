package com.sokolov.javafx.controller.controller;


import com.sokolov.javafx.controller.dbConnection.DBConnect;
import com.sokolov.javafx.controller.interfaces.impl.TableDokImpl;
import com.sokolov.javafx.controller.objects.Dok;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

public class MainController implements Initializable{

    private final ObservableList<Dok> dokObservableList = FXCollections.observableArrayList();

    @FXML
    public TitledPane titledPane;

    @FXML
    private TableColumn<Dok, String> columnNNDOK, columnNAME_USER, columnDate_Zap, columnDate_op, columnTipdokg, columnId_organiz;

    @FXML
    private TableView tableDok;



    @FXML
    private Button okButton;

    private Connection connection = null;

    private PreparedStatement preparedStatement = null;

    private Parent fxmlEdit;

    private FXMLLoader fxmlLoader = new FXMLLoader();


    public Stage getEditDialogStage() {
        return editDialogStage;
    }

    public void setEditDialogStage(Stage editDialogStage) {
        this.editDialogStage = editDialogStage;
    }

    private Stage editDialogStage;
    private ResourceBundle resourceBundle;
    private ObservableList<Dok> backupList;

    private Stage mainStage;
    private TableDokImpl tableDokImpl = new TableDokImpl();

    public Stage getMainStage() {
        return mainStage;
    }

    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }

    private void fillDate(){
        tableDokImpl.fillDataSet();

        backupList = FXCollections.observableArrayList();
        backupList.addAll(tableDokImpl.getDokList());
        tableDok.setItems(tableDokImpl.getDokList());

    }
    public void initialize(URL location, ResourceBundle resources) {
        this.resourceBundle = resources;


        columnNNDOK.setCellValueFactory(new PropertyValueFactory<Dok, String>("nn"));
        columnNAME_USER.setCellValueFactory(new PropertyValueFactory<Dok, String>("name_user"));
        columnDate_Zap.setCellValueFactory(new PropertyValueFactory<Dok, String>("date_zap"));
        columnDate_op.setCellValueFactory(new PropertyValueFactory<Dok, String>("date_op"));
        columnTipdokg.setCellValueFactory(new PropertyValueFactory<Dok, String>("tipdokg"));
        columnId_organiz.setCellValueFactory(new PropertyValueFactory<Dok, String>("id_organiz"));



        fillDate();
        connection = DBConnect.connection();

    }
}
