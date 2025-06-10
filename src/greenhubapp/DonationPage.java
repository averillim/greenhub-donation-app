/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package greenhubapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class DonationPage {
    public Stage secondaryStage;
    public ScrollPane postSection;
    public FlowPane postContainer;
    public TextArea titleTextArea;
    public TextField imagePathField;
    public TextArea descriptionTextArea;
    public TextArea goalTextArea;
    public TextField searchField;
    public TextArea titleTextAreaPost;
    public TextArea descriptionTextAreaPost;
    public TextArea goalTextAreaPost;
    public HBox header;
    public VBox postFields;
    public ToggleButton addPost;
    public ImageView imageView;
    public File selectedFile;
    
    public UserManagement userManagement = UserManagement.getInstance();
    Admin admin = new Admin();
    
     AllPosts allPostsInstance = AllPosts.getInstance();
    ArrayList<Post> allPosts = allPostsInstance.getAllPosts();

    private static DonationPage instance;

    public static DonationPage getInstance() {
        if (instance == null) {
            instance = new DonationPage();
        }
        return instance;
    }
    
    public void DonationPage(){
        createDonationPage();
         if(userManagement.getUser().equals(admin.getAdminName())){
            addPostButton();
            addPostFields();
        }
    }
    //Creating the donation page
    public void createDonationPage() {
        secondaryStage = new Stage();
        secondaryStage.setTitle("Donation");

        BorderPane posted = new BorderPane();
        posted.setBackground(new Background(new BackgroundFill(Color.AZURE, CornerRadii.EMPTY, Insets.EMPTY)));
        postFields = new VBox();
        posted.setRight(postFields);
        
        postFields.setVisible(false);
        
        Scene donation = new Scene(posted, 1000, 600);
        donation.setFill(Color.CADETBLUE);
        secondaryStage.setScene(donation);
        secondaryStage.show();
        
        Navigation navBar = new Navigation(secondaryStage, posted);
        posted.setLeft(navBar);
        navBar.setAlignment(Pos.CENTER);
        
        searchField = new TextField();
        Label searchLabel = new Label("Search:");
        searchLabel.setTextFill(Color.CADETBLUE);
        searchLabel.setFont(Font.font("Helvetica", FontWeight.BOLD, 14));
        searchField.textProperty().addListener((observable, oldValue, newValue) -> filterPosts(newValue));
        postContainer = new FlowPane();
        postContainer.setVgap(20);
             
        postSection = new ScrollPane(postContainer);
        postSection.setFitToWidth(true);
        postSection.setHbarPolicy(ScrollBarPolicy.NEVER);
        postSection.setVbarPolicy(ScrollBarPolicy.NEVER);
        postSection.setStyle("-fx-background: #F0FFFF; -fx-border-color: #F0FFFF;");
        postSection.setPadding(new Insets(20));
        posted.setCenter(postSection);
       
        header = new HBox();
        header.getChildren().addAll(searchLabel,searchField);
        header.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        header.setSpacing(20);
        header.setPadding(new Insets(10, 30, 10, 30));
        header.setAlignment(Pos.CENTER_RIGHT);      
        posted.setTop(header);
  
        for(Post showPost : allPosts){
            displayPost(showPost);
        }
    }
    
    public void addPostButton() {
        addPost = new ToggleButton("Add +");
        header.getChildren().add(addPost);  
    }
    
    public void addPostFields() {
        titleTextAreaPost = new TextArea();
        descriptionTextAreaPost = new TextArea();
        goalTextAreaPost = new TextArea();
        Button postButton = new Button("Post");
        
        Label imagePathLabel = new Label("Image Path:");
        imagePathField = new TextField();

        Button chooseImageButton = new Button("Choose Image");
        chooseImageButton.setOnAction(e -> chooseImage());

        imageView = new ImageView();
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);
        
        Label createLabel = new Label("Create a Post:");
        Label titleLabel = new Label("Title:");
        Label descLabel = new Label("Description:");
        Label goalLabel = new Label("Donation Goal:");
        
        createLabel.setTextFill(Color.TEAL);
        createLabel.setFont(Font.font("Helvetica", FontWeight.BOLD, 15));
        
        titleLabel.setTextFill(Color.CADETBLUE);
        titleLabel.setFont(new Font("Tahoma", 13));
        
        descLabel.setTextFill(Color.CADETBLUE);
        descLabel.setFont(new Font("Tahoma", 13));
        
        goalLabel.setTextFill(Color.CADETBLUE);
        goalLabel.setFont(new Font("Tahoma", 13));
        
        imagePathLabel.setTextFill(Color.CADETBLUE);
        imagePathLabel.setFont(new Font("Tahoma", 13));

        
        titleTextAreaPost.setPrefSize(200, 100);
        descriptionTextAreaPost.setPrefSize(200, 100);
        goalTextAreaPost.setPrefSize(200,100);
        
        postFields.setBackground(new Background(new BackgroundFill(Color.AZURE, CornerRadii.EMPTY, Insets.EMPTY)));
        postFields.setSpacing(20);
        postFields.setPadding(new Insets(30));
        postFields.setPrefSize(300, 800);
        
        postFields.getChildren().addAll( createLabel, titleLabel, titleTextAreaPost,descLabel, descriptionTextAreaPost, goalLabel, goalTextAreaPost, imagePathLabel, imagePathField, chooseImageButton, postButton);

        addPost.setOnAction(e -> postFields.setVisible(!postFields.isVisible()));
        
        chooseImageButton.setOnAction(e -> chooseImage());
        postButton.setOnAction(e -> postMessage());
    }
    
    private void chooseImage() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose Image File");
        fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif", "*.bmp", "*.jpeg")
        );
        
        Stage stage = new Stage();
        stage.setTitle("Create Post");
        stage.initModality(Modality.APPLICATION_MODAL);
        
        selectedFile = fileChooser.showOpenDialog(stage);
        if (selectedFile != null) {
            imagePathField.setText(selectedFile.getAbsolutePath());

            try {
                Image selectedImage = new Image(new FileInputStream(selectedFile));
                imageView.setImage(selectedImage);
            } catch (FileNotFoundException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Image file not found: " + e.getMessage());
                alert.showAndWait();
            }
        }
    }
    
    private void postMessage() {
        String title = titleTextAreaPost.getText().trim();
        String description = descriptionTextAreaPost.getText().trim();
        try{
            double goal = Double.parseDouble(goalTextAreaPost.getText());
            String imagePath = imagePathField.getText();
            Image image = null;
            if (!imagePath.isEmpty()) {
                try {
                    image = new Image(new FileInputStream(imagePath));
                } catch (FileNotFoundException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Image file not found: " + e.getMessage());
                    alert.showAndWait();
                }
            }

            if (!title.isEmpty() && !description.isEmpty() && goal > 0) {
                Post newPost = new Post(title, description, image, goal);
                allPosts.add(newPost);
                displayPost(newPost);
                clearInputFields();

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Post Failed");
                alert.setHeaderText(null);
                alert.setContentText("Post is empty. Please try again.");
                alert.showAndWait();
            }
        }
        catch(NumberFormatException ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(title);
            alert.setHeaderText(null);
            alert.setContentText("Please enter a valid number ");
            alert.showAndWait();
        }
        
       
    }

    private void displayPost(Post post) {
        PostContainer postBox = new PostContainer(post);
        postContainer.getChildren().add(postBox);
        DonationAdminButtons buttonBox = new DonationAdminButtons(post, this::deletePost, this::editPost);
        DonationBar donationProgress = new DonationBar();
        donationProgress.setSpacing(10);
        if (admin.getAdminName().equals(userManagement.getUser())) {
            postBox.getChildren().add(donationProgress);
            postBox.getChildren().add(buttonBox);
            
        } else {
            postBox.getChildren().add(donationProgress);
            postBox.getChildren().add(donationProgress.donateButton(post,allPosts));
        }
    }

    private void clearInputFields() {
        titleTextAreaPost.clear();
        descriptionTextAreaPost.clear();
        goalTextAreaPost.clear();
    }

    //Search feature
    private void filterPosts(String searchTerm) {
        postContainer.getChildren().clear();
        
        for (Post post : allPosts) {
            if (post.getTitle().toLowerCase().contains(searchTerm.toLowerCase())) {
                displayPost(post);
            }
        }
    }

    private void deletePost(Post post) {
        allPosts.remove(post);
        filterPosts(searchField.getText());
    }

    private void editPost(Post post) {
        Stage editStage = new Stage();
        editStage.initModality(Modality.APPLICATION_MODAL);
        editStage.initStyle(StageStyle.UTILITY);
        editStage.setTitle("Edit Post");
        editStage.setMinHeight(320);
        editStage.setMinWidth(350);

        VBox editBox = new VBox();
        titleTextArea = new TextArea(post.getTitle());
        descriptionTextArea = new TextArea(post.getDescription());
        goalTextArea = new TextArea(String.valueOf(post.getGoal()));
        Button saveButton = new Button("Save");

        saveButton.setOnAction(e -> {
            for (Post currentPost : allPosts) {
                if (currentPost.equals(post)) { 
                    currentPost.setTitle(titleTextArea.getText());
                    currentPost.setDescription(descriptionTextArea.getText());
                    currentPost.setGoal(Double.parseDouble(goalTextArea.getText()));
                    filterPosts(searchField.getText());
                    editStage.close();
                    break;
                }
            }
        });

        editBox.getChildren().addAll(new Label("Edit Title:"), titleTextArea,
                new Label("Edit Description:"), descriptionTextArea,
                new Label("Edit Donation Goal:"), goalTextArea, saveButton);

        Scene editScene = new Scene(editBox, 300, 200);
        editStage.setScene(editScene);
        editStage.showAndWait();
    }
}
