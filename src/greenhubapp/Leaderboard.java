/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package greenhubapp;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author abila
 */

public class Leaderboard extends Application {
    private Stage stage;
    private BorderPane root;
    private Scene scene;
    private Group boardLayout;
    
    private Rectangle border1;
    private Label user1;
    private Label userlv1;
    
    private Rectangle border2;
    private Label user2;
    private Label userlv2;
    
    private Rectangle border3;
    private Label user3;
    private Label userlv3;
    
    private Rectangle border4;
    private Label user4;
    private Label userlv4;

    //Creating a container for leaderboard data
    public void LeadData(Rectangle border, int x, int y,
                         Label username, String name,int a, int b,
                         Label userlevel, String level, int i, int j){
        
        border = new Rectangle(420,50, Color.CADETBLUE);
        border.setLayoutX(x); 
        border.setLayoutY(y);
        border.setArcHeight(33);
        border.setArcWidth(33);
        
        username = new Label(name);
        username.setLayoutX(a);
        username.setLayoutY(b);
        username.setTextFill(Color.WHITE);
        username.setFont(Font.font("Tahoma",20));
        
        userlevel = new Label(level);
        userlevel.setLayoutX(i);
        userlevel.setLayoutY(j);
        userlevel.setTextFill(Color.WHITE);
        userlevel.setFont(Font.font("Tahoma",20));
        
        
        boardLayout.getChildren().addAll(border,username,userlevel);
    }
    
    
    //Creating the start page
    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        boardLayout = new Group();
        root = new BorderPane();
        
        Navigation navBar = new Navigation(primaryStage, root);
        root.setLeft(navBar);
        navBar.setAlignment(Pos.CENTER);
        
        Label namelabel = new Label("Name");
        namelabel.setLayoutX(300);
        namelabel.setLayoutY(200);
        namelabel.setFont(Font.font("Tahoma",25));
        
        Label lvlabel = new Label("Level");
        lvlabel.setLayoutX(550);
        lvlabel.setLayoutY(200);
        lvlabel.setFont(Font.font("Tahoma",25));
        
        LeadData(border1,250,260,
                 user1,"Issac",310,270,
                 userlv1,"4",570,270);
        
        LeadData(border2,250,330,
                 user2,"Alice",310,340,
                 userlv2,"4",570,340);
        
        LeadData(border3,250,400,
                 user3,"Alex",310,410,
                 userlv3,"3",570,410);
        
        LeadData(border4,250,470,
                 user4,"Tom",310,480,
                 userlv4,"1",570,480);
        
        Label leadtxt = new Label("Leaderboard");
        leadtxt.setFont(Font.font("Tahoma",35));
        leadtxt.setLayoutX(360);
        leadtxt.setLayoutY(100);
        
        Rectangle line = new Rectangle(350,5,Color.CADETBLUE);
        line.setLayoutX(280);
        line.setLayoutY(160);
 
        boardLayout.getChildren().addAll(leadtxt,namelabel,lvlabel,line);
        GameButtons mybtn = new GameButtons();
        mybtn.toGameDash(boardLayout, stage,20, 360, 560, 190, 50);
        root.setCenter(boardLayout);
        scene = new Scene(root, 800, 600,Color.AZURE);
        
        stage.setTitle("Leaderboard");
        stage.setScene(scene);
        stage.show();
    }
}
