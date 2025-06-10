/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package greenhubapp;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Login {
    public Button loginButton;
    public TextField usernameField;
    public PasswordField passwordField;
    private static Login instance;
 
    
    public Button getLoginButton() {
        return loginButton;
    }
    //Creating the login scene
    public void Login() {
        Stage stage = new Stage();
        BorderPane root = new BorderPane();
        VBox brand = new VBox();
        
        Scene loginPage = new Scene(root);
        
        brand.setPadding(new Insets(100, 50, 100, 50));
        brand.setSpacing(20);
        brand.setPrefSize(400, 600);
        brand.setBackground(new Background(new BackgroundFill(Color.AZURE, CornerRadii.EMPTY, Insets.EMPTY)));
        
        Image logo = new Image("Images/logo.png");
        ImageView loginLogo = new ImageView(logo);
        
        Text appName = new Text("    GREENHUB");
        appName.setFill(Color.LIGHTSEAGREEN);
        appName.setFont(Font.font("Helvetica", FontWeight.BOLD, 50));
        brand.getChildren().addAll(loginLogo, appName);
        
        VBox loginLayout = new VBox();
        usernameField = new TextField();
        passwordField = new PasswordField();
        loginButton = new Button("Login");
        
        Label usernameLabel = new Label("Username:");
        Label passwordLabel = new Label("Password:");
        loginLayout.getChildren().addAll(usernameLabel, usernameField, passwordLabel, passwordField, loginButton);
        
        loginLayout.setPadding(new Insets(100, 50, 100, 50));
        loginLayout.setSpacing(40);
        loginLayout.setPrefSize(500, 500);
        loginLayout.setBackground(new Background(new BackgroundFill(Color.CADETBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
      
        usernameLabel.setTextFill(Color.WHITE);
        usernameLabel.setFont(new Font("Tahoma", 18));
        passwordLabel.setTextFill(Color.WHITE);
        passwordLabel.setFont(new Font("Tahoma", 18));
        
        root.setCenter(brand);
        root.setRight(loginLayout);
        
        Image icon = new Image("Images/hublogotrans.png");
        stage.getIcons().add(icon);
        
        stage.setScene(loginPage);
        stage.show();
        
        authenticate(stage);
        
        
    }
    //Authenticate the user
    public void authenticate(Stage stage) {
        
        Public publicUser = new Public();
        Admin adminUser = new Admin();
        
        getLoginButton().setOnAction(e -> {
            String usernameInput = usernameField.getText();
            String passwordInput = passwordField.getText();
            UserManagement userManagement = UserManagement.getInstance(); 

        //Checks the username and password with the public and admin classes
        if (usernameInput.equals(publicUser.getPublicName()) && passwordInput.equals(publicUser.getPublicPassword()) ||
                usernameInput.equals(adminUser.getAdminName()) && passwordInput.equals(adminUser.getAdminPassword())) {
            stage.close(); 
            userManagement.setUser(usernameInput);
            DonationPage.getInstance().DonationPage();
            
        }else {
                showAlert("Login Failed", "Invalid username or password. Please try again.");
            }
        });
        
    }
    
    public static Login getInstance() {
        if (instance == null) {
            instance = new Login();
        }
        return instance;
    }

    
    
    public static void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}    
