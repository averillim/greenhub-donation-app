/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package greenhubapp;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author Averil
 */
public class Navigation extends VBox {
    
    public Navigation(Stage stage, BorderPane root){
        //Create a navigation bar to link all pages 
       setBackground((new Background(new BackgroundFill(Color.CADETBLUE, CornerRadii.EMPTY, Insets.EMPTY))));
       setPrefSize(300, 600);
       setSpacing(25);
       
       ImageView headerLogo= new ImageView("Images/logo_head.png");
       
       Label greenhub = new Label("GREENHUB");
       greenhub.setTextFill(Color.color(0.196 , 1.0, 0.778));
       greenhub.setFont(Font.font("Helvetica",FontWeight.BOLD, 36));
        
       // to donations
       Label donation = new Label("Donations");
       donation.setTextFill(Color.WHITE);
       donation.setFont(Font.font("Tahoma",18));
       donation.setOnMouseClicked((MouseEvent event) -> {
           stage.close();
           DonationPage.getInstance().DonationPage();
       }
       );
       
       // to hazemap  
       Label hazemap = new Label("Haze map");     
       hazemap.setTextFill(Color.WHITE);
       hazemap.setFont(Font.font("Tahoma",18));
       hazemap.setOnMouseClicked((MouseEvent event) -> {
           stage.close();
            Hazetracker haze = new Hazetracker() {
               @Override
               public void start(Stage primaryStage) throws Exception {
                   throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
               }
           };
            haze.Hazetracker();
           
       });
       
       // to articles    
       Label articles = new Label("Articles");     
       articles.setTextFill(Color.WHITE);
       articles.setFont(Font.font("Tahoma",18));
       articles.setOnMouseClicked((MouseEvent event) -> {
           stage.close();
           ArticlePage.getInstance().ArticlePage();
       }//
       );
       
       // to calculator
       Label calculator = new Label("Calculator ");
       calculator.setTextFill(Color.WHITE);
       calculator.setFont(Font.font("Tahoma",18));
       calculator.setOnMouseClicked((MouseEvent event) -> {
           stage.close();
           CalcPublicUserView.getInstance().CalcPublicUserView();
       }//
       );
       
       // to game    
       Label game = new Label("Game");     
       game.setTextFill(Color.WHITE);
       game.setFont(Font.font("Tahoma",18));
       game.setOnMouseClicked((MouseEvent event) -> {
           stage.close();
           Gamedashboard.getInstance().Gamedashboard();
       }
       );
       
       //Log out btn
       Label logOut = new Label("Log Out");     
       logOut.setTextFill(Color.WHITE);
       logOut.setFont(Font.font("Tahoma",18));
       logOut.setOnMouseClicked((MouseEvent event) -> {
           stage.close();
           UserManagement userManagement = UserManagement.getInstance();
           userManagement.logOut();
       }//
       );
       
        Image icon = new Image("Images/hublogotrans.png");
        stage.getIcons().add(icon);
       
       getChildren().addAll(headerLogo, greenhub, donation, articles, 
               calculator, hazemap, game, logOut);
    }
}