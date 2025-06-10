/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package greenhubapp;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;

/**
 *
 * @author User
 */
public class HazeCustomButton extends Button{
    
    public HazeCustomButton(int setX, int setY, int Height, int Width, int opacity, Region region, String Admin){
        super();
        this.setStyle(
            "-fx-text-fill: white;" +
            "-fx-font-size: 14px;" +
            "-fx-padding: 10px 20px;" +
            "-fx-font-family: Tahoma;" +
            "-fx-text-fill: #000000;"
        );
        this.setOpacity(opacity);
        this.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                Dialog statesDialog = new StatesDialog(region, Admin);
                statesDialog.showAndWait();  
            }
        });
        setPrefSize(Width, Height);
        setLayoutX(setX);
        setLayoutY(setY);
    }

}
