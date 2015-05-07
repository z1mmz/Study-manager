/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.awt.Desktop;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javax.swing.text.html.ListView;

/**
 * FXML Controller class
 *
 * @author wolf
 */
public class HomeScreenController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML 
    private Label profileName;
    private String name;
    
    @FXML
    private Button settingsButton;
    
//    @FXML
//    private ListView classTodayList;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

//        profileName.setText(DataController.login);
         System.err.println("USERNAME AT MAIN SCREEN IS "+ name);
          profileName.setText(name);
//          classTodayList.
          
    }
    public void setUser(String userName){
        this.name = userName;
        profileName.setText("Hello "+name);
    }
    public void settingsClicked(ActionEvent event){
        
    }
    public void addCourseClicked(ActionEvent event) throws IOException{
        System.out.println("YOU PRESSED ME");
        Parent homePageParent = FXMLLoader.load(getClass().getResource("FXMLCreateCourse.fxml"));
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene homePageParentScene = new Scene(homePageParent);
        appStage.setScene(homePageParentScene);
        appStage.show();
    }
    
    
    

}
