/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package greenhubapp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author abila
 */
public class HowToPlay extends Application {
    private BorderPane root;
    
    //Creating the HowToPlay page 
    @Override
    public void start(Stage primaryStage) {
        root = new BorderPane();
        Group HowToLayout = new Group();
        VBox vboxLayout = new VBox();
        
        Navigation navBar = new Navigation(primaryStage, root);
        root.setLeft(navBar);
        navBar.setAlignment(Pos.CENTER);
        
        StackPane stackPlay = new StackPane();
        
        Label howtoplay = new Label("How To Play");
        howtoplay.setFont(Font.font("Tahoma",35));

        
        Label namelabel = new Label("Instructions");
        namelabel.setFont(Font.font("Tahoma",25));
        
        Rectangle instructionbg = new Rectangle(430,250,Color.CADETBLUE);
        instructionbg.setArcHeight(33);
        instructionbg.setArcWidth(33);
        
        Label instructionLabel = new Label("""
                                           1) You will be given an enviroment and\nyou must find problems that cause CO2. 
                                            \n2) By clicking on objects that may be the answer,\nyou can proceed to the next level. 
                                           \n3) For example: instead of throwing plastic\nbottles away you can recycle them""");
        instructionLabel.setTextFill(Color.WHITE);
        instructionLabel.setWrapText(true);
        instructionLabel.setFont(Font.font("Tahoma",17));
        
        
        stackPlay.getChildren().addAll(instructionbg,instructionLabel);
        
        vboxLayout.getChildren().addAll(howtoplay,namelabel,stackPlay);
        vboxLayout.setMargin(namelabel, new Insets(10,30,10,120));
        vboxLayout.setMargin(howtoplay, new Insets(10,30,10,110));
        vboxLayout.setPadding(new Insets(10, 0, 0, 25));
        vboxLayout.setSpacing(10);
       
        HowToLayout.getChildren().add(vboxLayout);
        GameButtons mybtn = new GameButtons();
        mybtn.toGameDash(HowToLayout, primaryStage, 20,130, 500, 200, 50);
        root.setCenter(HowToLayout);
        Scene scene = new Scene(root, 800, 600,Color.AZURE);
        
        primaryStage.setTitle("How To Play");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}
