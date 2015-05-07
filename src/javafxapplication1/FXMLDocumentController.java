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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

/**
 *
 * @author wolf
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label welcomeHeadin,errorMessage;
    @FXML
    private Hyperlink loginMessage;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField userNameField;
    //TAKES USERS TO CREATE LOGIN PAGE
    private String error;
    private static String userName;
    @FXML 
    public void displayError(ActionEvent event){
        loginMessage.setVisible(false);
        errorMessage.setText(error);
        errorMessage.setVisible(true);
        errorMessage.setWrapText(true);
        
    }
    @FXML
    private void handleNoLognButtonAction(ActionEvent event) throws IOException {
        System.out.println(userNameField.getText() + ":" + passwordField.getText());
        //LOAD WINDOW
        Parent homePageParent = FXMLLoader.load(getClass().getResource("FXMLCreateLogin.fxml"));
        //GET ROOT STAGE
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       // CREATE SCENE FROM FXML
        Scene homePageParentScene = new Scene(homePageParent);
        //SET THE SCENE
        appStage.setScene(homePageParentScene);
        //SHOW THE SCENE
        appStage.show();

    }

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        System.out.println(userNameField.getText() + ":" + passwordField.getText());
//        Parent homePageParent = FXMLLoader.load(getClass().getResource("HomeScreen.fxml"));
  
        //IF LOGIN IS A SUCCESS TAKE USER TO HOME SCREEN
        if (login() == true) {
           userName = userNameField.getText();
           FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("HomeScreen.fxml"));
           Parent root = (Parent)fxmlLoader.load();
           HomeScreenController controller = fxmlLoader.<HomeScreenController>getController();
           controller.setUser("HURRDURR");
        
           Scene homePageParentScene = new Scene(root,650,400);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(homePageParentScene);
             controller.setUser(userName);
            appStage.show();
            
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        // Was playing with storing dates this works!
//        String datey = "12 10 1993 13:20";
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy HH:mm", Locale.ENGLISH);
//        LocalDate date = LocalDate.parse(datey, formatter);
//        LocalDateTime time = LocalDateTime.parse(datey, formatter);
//        System.out.println(date);
//        System.out.println(time.getHour()+":"+time.getMinute());
    }

    public boolean login() {
        errorMessage.setVisible(false);
        loginMessage.setVisible(true);
        Connection c = null;
        Statement stmt = null;
        try {
//            Class.forName("org.sqlite.JDBC"); 
            boolean loggedIn = false;
            c = DriverManager.getConnection("jdbc:sqlite:users.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM UserTable WHERE USERNAME= " + "'" + userNameField.getText() + "'" + "AND PASSWORD= "
                    + "'" + passwordField.getText() + "'");
            while (rs.next()) {
                if (rs.getString("USERNAME") != null && rs.getString("PASSWORD") != null) {
                    String userName = rs.getString("USERNAME");
                    String passWord = rs.getString("PASSWORD");
                    
                    System.out.println(userName);
                    System.out.println(passWord);
                    c.close();
                    loggedIn = true;
                    JavaFXApplication1.setUserName(userNameField.getText());
                    return true;
                }
               
            }
            loginMessage.setText("Login Failed");
            error = "Invalid username or password";
            userNameField.requestFocus();
           c.close();
            return false;
          
        } catch (SQLException e) {
           loginMessage.setText("Login Failed");         
            error = e.getMessage();
            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        }
     

    }
       public static String getUser(){
            return userName;
        }
    

}
