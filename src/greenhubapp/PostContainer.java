/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package greenhubapp;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class PostContainer extends VBox {
    //Creating a post container 
    public PostContainer(Post post) {
        
        Label titleLabel = new Label(post.getTitle());
        Label descriptionLabel = new Label(post.getDescription());
        Label goalLabel = new Label("Goal: RM " + post.getGoal());
        
        titleLabel.setTextFill(Color.WHITE);
        titleLabel.setFont(Font.font("Tahoma", FontWeight.BOLD, 25));
        
        descriptionLabel.setTextFill(Color.WHITE);
        descriptionLabel.setFont(new Font("Tahoma", 15));
        
        Image image = post.getImage();
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(150);
        imageView.setPreserveRatio(true);
        imageView.setX(10);

        VBox postText = new VBox(titleLabel, descriptionLabel);
        HBox postImage = new HBox(imageView, postText);
        VBox postLayout = new VBox (postImage, goalLabel);
        
        postText.setSpacing(30);
        postImage.setSpacing(10); 
        postLayout.setSpacing(10);

        getChildren().add(postLayout);
        setBackground(new Background(new BackgroundFill(Color.rgb(130, 181, 183), CornerRadii.EMPTY, Insets.EMPTY)));
        setSpacing(10);
        setPrefSize(600, 250);
        setStyle("-fx-padding: 20;" + "-fx-border-radius: 5;");
        setAlignment(Pos.CENTER_LEFT);
        
        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(5);
        dropShadow.setOffsetX(5);
        dropShadow.setOffsetY(5);
        dropShadow.setColor(Color.LIGHTGRAY);

        setEffect(dropShadow);
    }
    
}

