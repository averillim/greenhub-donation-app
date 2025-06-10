/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package greenhubapp;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javax.script.ScriptEngine;

/**
 *
 * @author abila
 */

public class Gamedashboard{
    
    private static Gamedashboard instance;
    
    private BorderPane root;    
    private Scene scene;
    private Stage stage;
    private Group gameLayout;
  //Creating the play button
    private void play(){
        Levels mylevels = new Levels();
        Button switchbtn = new Button();
        switchbtn.setText("Play");
        switchbtn.setFont(Font.font("Tahoma",20));
        switchbtn.setOnAction((ActionEvent event) -> {
            stage.close();
            mylevels.GetReady();
        });
        switchbtn.setPrefSize(170, 50);
        switchbtn.setLayoutX(370);
        switchbtn.setLayoutY(300);
        gameLayout.getChildren().add(switchbtn);
    }
    //Creating the howtoplay button
    private void HowToPlay(){
        Button howToBtn = new Button();
        howToBtn.setText("How To Play");
        howToBtn.setOnAction((ActionEvent event) -> {
            stage.close();
            HowToPlay howtoplay = new HowToPlay();
            howtoplay.start(stage);
        });
        howToBtn.setFont(Font.font("Tahoma",20));
        howToBtn.setPrefSize(170, 50);
        howToBtn.setLayoutX(370);
        howToBtn.setLayoutY(400);
        gameLayout.getChildren().add(howToBtn);
    }
    //Creating the leaderboard button
    private void LeaderBoard(){
        Button leadbtn = new Button();
        leadbtn.setText("Leaderboard");
        leadbtn.setOnAction((ActionEvent event) -> {
            stage.close();
            Leaderboard leaderboard = new Leaderboard();
            leaderboard.start(stage);
        });
        leadbtn.setFont(Font.font("Tahoma",20));
        leadbtn.setPrefSize(170, 50);
        leadbtn.setLayoutX(370);
        leadbtn.setLayoutY(500);
        gameLayout.getChildren().add(leadbtn);

    }
    //Creating the title
    private void Gamepage(){
        Label name = new Label("CO2 Game");
        name.setFont(Font.font("Tahoma",35));
        name.setLayoutX(380);
        name.setLayoutY(150);
        gameLayout.getChildren().add(name);   
        
    }
    
 //Creating the dashboard homepage
    public void Gamedashboard() {
        stage = new Stage();
        root = new BorderPane();
        gameLayout = new Group();
        
        Navigation navBar = new Navigation(stage, root);
        root.setLeft(navBar);
        navBar.setAlignment(Pos.CENTER);
        
        Gamepage();
        play();
        HowToPlay();
        LeaderBoard();
        root.setCenter(gameLayout);
        scene = new Scene(root, 800, 600,Color.AZURE);
        
        stage.setTitle("Game Dashboard");
        stage.setScene(scene);
        stage.show();
    }
    
    public static Gamedashboard getInstance() {
        if (instance == null) {
            instance = new Gamedashboard();
        }
        return instance;
    }
    
}
