/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author wolf
 */
public class JavaFXApplication1 extends Application {

   static String userName; 

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root, 300, 275);
        stage.setScene(scene);
        stage.setTitle("OSSM");
        stage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public static String getUserName() {
        System.out.println("USERNAME IN APP IS: "+userName);
            return JavaFXApplication1.userName;
    }

    public static void setUserName(String name) {
        System.out.println("Name passed: "+name);
        JavaFXApplication1.userName = name;
    }

}
