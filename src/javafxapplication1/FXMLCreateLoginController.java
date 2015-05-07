/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author wolf
 */
public class FXMLCreateLoginController implements Initializable {

    @FXML
    private PasswordField passWordField;
    @FXML
    private TextField userNameField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void createLoginSQL(ActionEvent event) throws IOException {
        Connection c = null;
        Statement stmt = null;
        try {
            c = DriverManager.getConnection("jdbc:sqlite:Users.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            String sql = "INSERT INTO UserTable (USERNAME,PASSWORD)"
                    + "VALUES (" + "'" + userNameField.getText() + "'," + "'" + passWordField.getText() + "');";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            c.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("ASDASDASDASASD");
            if (e.getMessage().matches("no such table: UserTable")) {
                try{
                c = DriverManager.getConnection("jdbc:sqlite:Users.db");
                c.setAutoCommit(false);
                System.out.println("Opened database successfully");
                stmt = c.createStatement();
                String sql = "CREATE TABLE"+"'"+"UserTable"+"'"+"("+"'"+"USERNAME"+"'"+"TEXT NOT NULL,"+"'"+"PASSWORD"+"'"+"TEXT NOT NULL,"+"PRIMARY KEY(USERNAME))";
                System.out.println(sql);
                stmt.executeUpdate(sql);
                sql = "INSERT INTO UserTable (USERNAME,PASSWORD)"
                    + "VALUES (" + "'" + userNameField.getText() + "'," + "'" + passWordField.getText() + "');";
                System.out.println(sql);
                stmt.executeUpdate(sql);
                stmt.close();
                c.commit();
                c.close();
                }catch(SQLException x){
                    System.out.println(x.getMessage());
                }
            }

        }
        Parent homePageParent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene homePageParentScene = new Scene(homePageParent);
        appStage.setScene(homePageParentScene);
        appStage.show();

    }

}
