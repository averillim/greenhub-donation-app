/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package greenhubapp;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author abila
 */
public class GameButtons {
    //Creating buttons 
    Levels mylevels = new Levels();
    
    public void offbtn(Stage stage,Group root, int x, int y, int w, int h){
        Button btn = new Button();
        btn.setText("OFF");
        btn.setOnAction((ActionEvent event) -> {
            stage.close();
            mylevels.Lv1Pass();
        });
        
        btn.setOpacity(0);
        btn.setPrefWidth(w); 
        btn.setPrefHeight(h); 
        btn.setLayoutX(x); 
        btn.setLayoutY(y); 
        root.getChildren().add(btn);
    }
    
    public void toLv2(Group root, Stage stage, int x, int y, int w, int h){
        Button btn = new Button();
        btn.setText(" Continue ");
        btn.setOnAction((ActionEvent event) -> {
            stage.close();
            mylevels.startlevelTwo(stage);
        });
        btn.setPrefWidth(w); 
        btn.setPrefHeight(h);
        btn.setLayoutX(x); 
        btn.setLayoutY(y); 
        btn.setFont(Font.font("Tahoma",25));
        root.getChildren().add(btn);
        
    }
    
    public void OffBtnLv2(Stage stage,Group root, int x, int y, int w, int h){
        Button btn = new Button();
        btn.setText("OFF");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.close();
                mylevels.Complete();
            }
        });
        
        btn.setOpacity(0);
        btn.setPrefWidth(w); 
        btn.setPrefHeight(h); 
        btn.setLayoutX(x); 
        btn.setLayoutY(y); 
        root.getChildren().add(btn);
    }
    
    public void toGameDash(Group root, Stage stage, int size,int x, int y, int w, int h){
        Button btn = new Button();
        btn.setText("Dashboard");
        btn.setOnAction((ActionEvent event) -> {
            stage.close();
            Gamedashboard.getInstance().Gamedashboard();
        });
        btn.setPrefWidth(w); 
        btn.setPrefHeight(h); 
        btn.setLayoutX(x); 
        btn.setLayoutY(y); 
        btn.setFont(Font.font("Tahoma",size));
        root.getChildren().add(btn);
        
    }
}
