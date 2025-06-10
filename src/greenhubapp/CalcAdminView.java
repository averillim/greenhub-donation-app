package greenhubapp;


import javafx.scene.Scene;
import javafx.geometry.*;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class CalcAdminView{
    private static CalcAdminView instance;
    Stage stage = new Stage();
    public static double weeklyLimit = 100;
    
    public static double getWeeklyLimit()
    {
        return weeklyLimit;
    }
    
    public static void setWeeklyLimit(double newLimit)
    {
        weeklyLimit = newLimit;
    }
    
    public void CalcAdminView(){
        showAdminScene(stage);
    }
    
    public static CalcAdminView getInstance() {
        if (instance == null) {
            instance = new CalcAdminView();
        }
        return instance;
    }
    
    //Creating a scene for admin
    public void showAdminScene(Stage primaryStage)
    {
        primaryStage.setTitle("Greenhub Admin");
        
        // UI SECTION //
            

            //title
            Label helloAdminTitle = new Label("Hello, Admin!");
            helloAdminTitle.setStyle("-fx-font-family: Verdana; -fx-text-fill: black; -fx-font-size: 20px;");
            //weeklyLimit label and field
            Label weeklyLimitLabel = new Label("New Weekly Limit (kg): ");
            weeklyLimitLabel.setStyle("-fx-font-family: Verdana; -fx-text-fill: black; -fx-font-size: 16px;");
            TextField weeklyLimitField = new TextField();
            weeklyLimitField.setStyle("-fx-font-family: Verdana; -fx-text-fill: black; -fx-font-size: 16px;");
            //sizes
            weeklyLimitLabel.setPrefSize(300,25);
            weeklyLimitField.setPrefSize(70,25);
            //update button and function
            Button updateButton = new Button("Update");
            updateButton.setStyle("-fx-font-family: Verdana; -fx-background-color: CADETBLUE; -fx-text-fill: white; -fx-font-size: 16px;");
            updateButton.setOnAction(e ->
            {
                String newLimit = weeklyLimitField.getText();
                try
                {
                    double limit = Double.parseDouble(newLimit);
                    setWeeklyLimit(limit);
                    showAlertAndAskToStay("Success!", "Weekly limit updated to: " + newLimit + "kg");
                }
                catch (NumberFormatException ex)
                {
                    showAlert(Alert.AlertType.ERROR, "Error", "Please enter a valid number.");
                }
            }
            );
       
            //title vbox
            VBox title = new VBox();
            title.setLayoutX(205);
            title.setLayoutY(205);
            title.getChildren().addAll(helloAdminTitle);
            //vbox (label, left)
            VBox vb2 = new VBox();
            vb2.setSpacing(10);
            vb2.setLayoutX(130);
            vb2.setLayoutY(280);
            vb2.getChildren().addAll(weeklyLimitLabel);

            //vbox (field, right)
            VBox vb3 = new VBox();
            vb3.setSpacing(10);
            vb3.setLayoutX(330);
            vb3.setLayoutY(280);
            vb3.getChildren().addAll(weeklyLimitField);
            //vbox (update button, right)
            VBox update = new VBox();
            update.setSpacing(10);
            update.setLayoutX(330);
            update.setLayoutY(330);
            update.getChildren().addAll(updateButton);
            //borderpanes
            BorderPane borderPane = new BorderPane();
            Navigation navBar = new Navigation(primaryStage, borderPane);
            borderPane.setLeft(navBar);
            navBar.setAlignment(Pos.CENTER);
            //pane
            Pane pane = new Pane();
            pane.getChildren().addAll( title, vb2,  vb3, update);
            pane.setPadding(new Insets(20));
            pane.setStyle("-fx-background-color: azure");
            borderPane.setCenter(pane);

            //scene section, displaying all
            Scene scene = new Scene(borderPane, 800, 600);
            primaryStage.setScene(scene);
            primaryStage.show();
            primaryStage.setResizable(false);
    }

    // METHODS SECTION //
    private void showAlert(Alert.AlertType alertType, String title, String message)
    {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showAlertAndAskToStay(String title, String message)
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.getButtonTypes().clear();
        alert.getButtonTypes().add(ButtonType.OK);
        alert.showAndWait();    

    }
}
