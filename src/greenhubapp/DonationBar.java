/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package greenhubapp;

import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Averil
 */
public class DonationBar extends HBox {
    private double totalDonations = 0.0;
    private double donationGoal;
    private final ProgressBar donationBar;
    private final Label goalReachedLabel;
    
    //Creating the donationbar
    public DonationBar() {

        donationBar = new ProgressBar();
        donationBar.setProgress(totalDonations);
        donationBar.setStyle("-fx-accent: teal;");
        donationBar.setPrefWidth(300);
        
        goalReachedLabel = new Label("Goal Not Reached");

        setPadding(new Insets(20));
        getChildren().addAll(  donationBar, goalReachedLabel);

    }
    
    public Button donateButton(Post post,ArrayList<Post> allPosts) {
        Button donateButton = new Button("Donate");
        donateButton.setOnAction(e -> showDonationDialog(post,allPosts,donationBar, goalReachedLabel));
        return donateButton;
    }
    
    private void showDonationDialog(Post post,ArrayList<Post> allPosts,ProgressBar donationProgressBar, Label goalReachedLabel) {
        // Create a new stage for the donation dialog
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Enter Donation Amount");

        // Create UI components for the donation dialog
        Label label = new Label("Enter donation amount:");
        TextField donationTextField = new TextField();
        Button confirmButton = new Button("Confirm");

        // Set up layout for the donation dialog
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20));
        vbox.getChildren().addAll(label, donationTextField, confirmButton);

        // Set up event handling for the confirm button
        confirmButton.setOnAction(e -> {
            processDonation(post,allPosts,donationTextField, dialogStage, donationProgressBar, goalReachedLabel);
        });

        // Set up the scene for the donation dialog
        Scene dialogScene = new Scene(vbox, 300, 150);
        dialogStage.setScene(dialogScene);

        // Show the donation dialog
        dialogStage.show();
    }

    private void processDonation(Post post,ArrayList<Post> allPosts,TextField donationTextField, Stage dialogStage, ProgressBar donationProgressBar, Label goalReachedLabel) {
        try {
            double amount = Double.parseDouble(donationTextField.getText());
            if (amount > 0) {
                totalDonations += amount;
                Post latestPost = null;
                for(int i=0; i<allPosts.size(); i++){
                    Post currentPost = allPosts.get(i);
                    if(currentPost.getTitle().equals(post.getTitle())){
                        latestPost = currentPost;
                        break;
                    }
            }
                updateDonationProgressBar(latestPost, donationProgressBar, goalReachedLabel);
                dialogStage.close();
            } else {
                showAlert("Invalid Donation Amount", "Please enter a positive number.");
            }
        } catch (NumberFormatException e) {
            showAlert("Invalid Donation Amount", "Please enter a valid number.");
        }
    }

    private void updateDonationProgressBar(Post post, ProgressBar donationProgressBar, Label goalReachedLabel) {
        donationGoal = post.getGoal();
        double progress = totalDonations / donationGoal;
        int percentage = (int)(progress*100);
        donationProgressBar.setProgress(progress);

        if (totalDonations >= donationGoal) {
            donationProgressBar.setStyle("-fx-accent: turquoise;");
            goalReachedLabel.setText("Goal Reached! Thank you!");
        } else {
            goalReachedLabel.setText(percentage + "%");
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}

