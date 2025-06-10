/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package greenhubapp;

import java.util.ArrayList;
import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;





/**
 *
 * @author bianca
 */
public class ArticlePage {
    private ArticleManager articleManager = new ArticleManager();
    private ListView<String> articleListView = new ListView<>();
    public Stage stage;
    private ObservableList<String> articles = FXCollections.observableArrayList();
    private ListView<String> searchResultsView = new ListView<>();
    
    private static ArticlePage instance;
    Admin admin = new Admin();
    UserManagement userManagement = UserManagement.getInstance();
            
     //Textfield for the searchfield
     private TextField SearchField(){
        TextField searchField = new TextField();
        searchField.setPromptText("Search articles");
        searchField.setFont(Font.font("Tahoma", 14));
        return searchField;
    }
     private VBox articleBoxes(){
        VBox articleBoxes = new VBox();
        articleBoxes.setSpacing(10);
        articleBoxes.setPadding(new Insets(10));
        articleBoxes.setStyle("-fx-background-color: cadetblue;");
        return articleBoxes;
     }
     
     public void ArticlePage(){
         stage = new Stage();
         stage.setScene(getAdminScene());
         stage.show();
     }
     public Scene getAdminScene() {

        BorderPane borderPane = new BorderPane();
        Navigation navBar = new Navigation(stage, borderPane);
        borderPane.setLeft(navBar);
        navBar.setAlignment(Pos.CENTER);

        VBox layout = new VBox();
        
        VBox searchAndTitle = new VBox();
        searchAndTitle.setSpacing(10);
        searchAndTitle.setPadding(new Insets(10));
        
        Label logoLabel = new Label("ARTICLES");
        logoLabel.setFont(Font.font("Helvetica", 22));
        logoLabel.setTextFill(Color.BLACK);
        
        searchAndTitle.getChildren().add(logoLabel);
        searchAndTitle.setMargin(logoLabel, new Insets(10, 30, 10, 30));
        
        VBox articleBoxes = articleBoxes();
        searchbar(articleBoxes, searchAndTitle);
        AddButton(searchAndTitle, articleBoxes);
        
        layout.setMargin(articleBoxes, new Insets(10, 30, 10, 30)); 
        layout.setMargin(searchAndTitle, new Insets(10, 30, 10, 30)); 

        layout.getChildren().addAll(searchAndTitle,articleBoxes);
        
        layout.setPrefWidth(650);
        ScrollPane scrollPane = new ScrollPane(layout);
        
        for(Article showArticle : articleManager.getArticles()){
            VBox articleBox = createArticleBox(showArticle);
            articleBoxes.getChildren().add(articleBox);
        }
        
        Scene articleScene = new Scene(borderPane, 1000, 600);   
        scrollPane.setFitToWidth(true); // Adjust to the width of the content
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        borderPane.setCenter(scrollPane);
        
        scrollPane.setPrefSize(1000, 600);
        scrollPane.setBackground(new Background(new BackgroundFill(Color.AZURE, CornerRadii.EMPTY, Insets.EMPTY)));

        return articleScene;
    }
     
     public static ArticlePage getInstance() {
        if (instance == null) {
            instance = new ArticlePage();
        }
        return instance;
    }
    
    private void AddButton(VBox layout, VBox articleBoxes){
        Button AddButton = new Button("Add Article");
        AddButton.setOnAction(event -> {
           AddDialog(articleBoxes);
        });
        if(userManagement.getUser().equals(admin.getAdminName())){
            layout.getChildren().add(AddButton);
            layout.setMargin(AddButton, new Insets(10, 30, 10, 30));
        }
        
    }
    public void AddDialog(VBox articleBoxes){
         Dialog addDialog = new Dialog();
            addDialog.setTitle("Add Article");
            addDialog.setHeaderText("Add Article Details");
            addDialog.setContentText("Add article title:");

    addDialog.setTitle("Add Article");
    addDialog.setHeaderText("Add Article Details");

    GridPane grid = new GridPane();
    grid.setHgap(10);
    grid.setVgap(10);
    grid.setPadding(new Insets(20, 150, 10, 10));

    TextField titleField = new TextField();
    TextArea contentArea = new TextArea();
    contentArea.setPrefRowCount(5);
    TextField authorField = new TextField();

    grid.add(new Label("Title:"), 0, 0);
    grid.add(titleField, 1, 0);
    grid.add(new Label("Content:"), 0, 1);
    grid.add(contentArea, 1, 1);
    grid.add(new Label("Author:"), 0, 2);
    grid.add(authorField, 1, 2);
     
    
    addDialog.getDialogPane().setContent(grid);
        
        ButtonType submitBtn = new ButtonType("Submit");
        addDialog.getDialogPane().getButtonTypes().setAll(submitBtn);
        Optional<ButtonType> result = addDialog.showAndWait();

        if (result.isPresent() && result.get() == submitBtn) {
            String addedTitle = titleField.getText();
            String addedContent = contentArea.getText();
            String addedAuthor = authorField.getText();
            Article newArticle = new Article(addedTitle, addedContent, addedAuthor);
            // Add the new article to the article manager
            articleManager.addArticle(newArticle);

        }
    }
    
    //Creating the searchbar
    private void searchbar(VBox articleBoxes, VBox layout) {
        TextField SearchField = SearchField();
        Button searchButton = new Button("Search");
        searchButton.setFont(Font.font("Tahoma", 14));
        HBox searchBar = new HBox(20, SearchField, searchButton);

        searchButton.setOnAction(event -> {
            String query = SearchField.getText();
            displaySearchResults(query, articleBoxes);
        });

        layout.getChildren().addAll(searchBar);
        layout.setMargin(searchBar, new Insets(10, 30, 10, 30));
     }

    private void displaySearchResults(String query, VBox articleBoxes) {
         ArrayList<Article> foundArticles = articleManager.searchArticles(query);

    // Clear previous search results
    articleBoxes.getChildren().clear();

    // Display search results
    for (Article article : foundArticles) {
        VBox articleBox = createArticleBox(article);
        articleBoxes.getChildren().add(articleBox);
    }
}
   
   public void editDialog(Article article){
        Dialog editDialog = new Dialog();
            editDialog.setTitle("Edit Article");
            editDialog.setHeaderText("Edit Article Details");
            editDialog.setContentText("Edit article title:");

    editDialog.setTitle("Edit Article");
    editDialog.setHeaderText("Edit Article Details");


    GridPane grid = new GridPane();
    grid.setHgap(10);
    grid.setVgap(10);
    grid.setPadding(new Insets(20, 150, 10, 10));

    TextField titleField = new TextField(article.getTitle());
    TextArea contentArea = new TextArea(article.getContent());
    contentArea.setPrefRowCount(5);
    TextField authorField = new TextField(article.getAuthor());

    grid.add(new Label("Title:"), 0, 0);
    grid.add(titleField, 1, 0);
    grid.add(new Label("Content:"), 0, 1);
    grid.add(contentArea, 1, 1);
    grid.add(new Label("Author:"), 0, 2);
    grid.add(authorField, 1, 2);
     

    editDialog.getDialogPane().setContent(grid);

        ButtonType submitBtn = new ButtonType("Submit");
        editDialog.getDialogPane().getButtonTypes().setAll(submitBtn);
        Optional<ButtonType> result = editDialog.showAndWait();

        if (result.isPresent() && result.get() == submitBtn) {
            String editedTitle = titleField.getText();
            String editedContent = contentArea.getText();
            String editedAuthor = authorField.getText();

            articleManager.editArticle(article, editedTitle, editedContent, editedAuthor);
            TextField SearchField = SearchField();
            displaySearchResults(SearchField.getText(), articleBoxes());
        }
}
 
   public VBox createArticleBox(Article article) {
    VBox articleBox = new VBox();
    articleBox.setStyle("-fx-border-color: black; -fx-padding: 10px; -fx-background-color: cadetblue;");

    Label titleLabel = new Label(article.getTitle());
    titleLabel.setFont(Font.font("Tahoma", FontWeight.BOLD, 16));
    titleLabel.setAlignment(Pos.CENTER); // Title at the top middle
    titleLabel.setTextFill(Color.WHITE);
    
    Label contentLabel = new Label(article.getContent());
    contentLabel.setFont(Font.font("Tahoma", 12));
    contentLabel.setWrapText(true); // Summary of the article
    contentLabel.setTextFill(Color.WHITE);
    
    Label authorLabel = new Label("Author: " + article.getAuthor());
    authorLabel.setFont(Font.font("Tahoma", FontWeight.BOLD, 12)); // Author name
    authorLabel.setTextFill(Color.WHITE);
    
    Button deleteButton = new Button("Delete");
    deleteButton.setOnAction(event -> {
        articleManager.deleteArticle(article);
        TextField SearchField = SearchField();
        displaySearchResults(SearchField.getText(), articleBoxes());
    });
    deleteButton.setStyle("-fx-background-color: red; -fx-text-fill: white;"); 
    
    
    Button editButton = new Button("Edit");
    editButton.setOnAction(event -> {
        editDialog(article);

    });
    editButton.setStyle("-fx-background-color: orange; -fx-text-fill: white;"); // Edit button
    
    HBox buttonsBox = new HBox(deleteButton, editButton);
    buttonsBox.setAlignment(Pos.BOTTOM_RIGHT); // Delete and Edit buttons arrangement
    buttonsBox.setMargin(deleteButton, new Insets(10,10,10,10));
    buttonsBox.setMargin(editButton, new Insets(10,10,10,10));
    titleLabel.setPadding(new Insets(10, 10, 5, 10));
    contentLabel.setPadding(new Insets(5,10,5,10));
    authorLabel.setPadding(new Insets(5,10,2,10));
    

    // Add components directly to articleBox
    articleBox.getChildren().addAll(titleLabel, contentLabel, authorLabel);
    if(userManagement.getUser().equals(admin.getAdminName())){
        articleBox.getChildren().add(buttonsBox);
        }
    articleBox.setSpacing(5); // Spacing between elements

    return articleBox;
}
}
