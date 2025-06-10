/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package greenhubapp;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.StageStyle;

/**
 *
 * @author User
 */
public class HazeEditDialog extends Dialog<States>{
    Region region;
    String admin;
    
    private TextField coEmiss = new TextField();
    private TextField levelAPI = new TextField();

    public HazeEditDialog(Region region, String admin){
        super();
        this.region = region;
        this.admin = admin;
        
        initStyle(StageStyle.DECORATED);
        
        setTitle("Change Region Data");
        setHeaderText("Enter new data levels for " + region.getName()+ ": ");
        coEmiss.setText(String.valueOf(region.getCarbonEmission()));
        levelAPI.setText(String.valueOf(region.getlevelAPI()));
        
        GridPane grid = new GridPane();
        grid.add(new Label("New Carbon Emission:"), 0, 0);
        grid.add(new Label("New Air Pollution Index:"), 0, 1);
        grid.add(coEmiss, 1, 0);
        grid.add(levelAPI, 1, 1);
        
        getDialogPane().setContent(grid);
        getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        
        setResultConverter(buttonType -> {
            if (buttonType == ButtonType.OK) {
                // Process the entered carbon emission level
                try {
                    int newCarbonEmission = Integer.parseInt(coEmiss.getText());
                    int API = Integer.parseInt(levelAPI.getText());
                    
                    region.setEmission(newCarbonEmission);
                    region.setAPI(API);

                } catch (NumberFormatException e) {
                    // Handle the case where the input is not a valid double
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Please enter a valid number ");
                    alert.showAndWait();
                }
            }
            return null;
        });
        
    }
}
