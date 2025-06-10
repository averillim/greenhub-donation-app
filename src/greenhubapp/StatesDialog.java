package greenhubapp;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.StageStyle;

public class StatesDialog extends Dialog<States>{
    Region region;
    String danger;
    Admin AdminClass = new Admin();
    String admin = AdminClass.getAdminName();
    UserManagement userManagement = UserManagement.getInstance();
    
    public StatesDialog(Region region, String admin){
        super();
        this.region = region;
        this.admin = admin;
        
        GridPane grid = new GridPane();
        
        initStyle(StageStyle.DECORATED);
        
        Label coEmissLabel = new Label(region.getName() + " Carbon Emission is " + region.getCarbonEmission() + " million tonnes annually");
        
        if (region.getlevelAPI() < 50){
            danger = "which is very low haze, it is very healthy.";
        } else if (region.getlevelAPI() >= 50 && region.getlevelAPI() < 100){
            danger = "light haze, consider wearing a mask when outside.";
        } else if (region.getlevelAPI() >= 100 && region.getlevelAPI() < 200){
            danger = "moderate haze, mask is a necessity";
        } else {
            danger = "very heavy haze, avoid going out often and wear masks";
        }
        Label coPPM = new Label("The air in " + region.getName() + " currently has " + region.getlevelAPI() + " Air Pollution Index score which is " + danger);
        grid.add(coEmissLabel, 0, 0);
        grid.add(coPPM, 0, 1);
        Button editButton = new Button("Edit");
        editButton.setOnAction((ActionEvent event) -> {
            Dialog editDialog = new HazeEditDialog(region, admin);
            editDialog.showAndWait();
        });
        editButton.setPrefWidth(100);
        editButton.setStyle("-fx-background-color: #4CAF50");
        
        if(userManagement.getUser().equals(admin)){
            editButton.setDisable(false);
        }else{
            editButton.setDisable(true);
            editButton.setOpacity(0);
        }
       
        grid.add(editButton, 0, 2);
        grid.setVgap(20);

        getDialogPane().setContent(grid);
        getDialogPane().setStyle("-fx-background-color: #5f9ea0;" +
                "-fx-font-size: 16px;" +
                "-fx-font-family: Tahoma;");
        getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
    }
}
