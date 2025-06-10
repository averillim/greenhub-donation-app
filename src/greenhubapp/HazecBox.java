package greenhubapp;


import javafx.scene.control.ChoiceBox;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class HazecBox extends ChoiceBox<String>{
    
    public HazecBox(String[] items, String setValue, int setLayoutX, int setLayoutY, int setPrefWidth, int setPrefHeight, String bgColor){
        this.getItems().addAll(items);
        this.setValue(setValue);
        this.setLayoutX(setLayoutX);
        this.setLayoutY(setLayoutY);
        this.setPrefWidth(setPrefWidth);
        this.setPrefHeight(setPrefHeight);
        this.setStyle(bgColor);
    }
    
}
