/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package greenhubapp;

import javafx.application.Application;
import javafx.stage.Stage;

public class GreenHubApp extends Application {
    public Stage stage;
    //Main page to start 
    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        primaryStage.setTitle("GreenHub");
        primaryStage.setMinWidth(800);
        primaryStage.setMinHeight(600);
        
        Login loginPage = new Login();
        loginPage.Login();
       
    }
    
    public Stage getStage() {
        return stage;
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
