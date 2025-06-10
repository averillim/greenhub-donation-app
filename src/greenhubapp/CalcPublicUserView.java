package greenhubapp;

import java.io.*;
import javafx.scene.Scene;
import javafx.geometry.*;
import javafx.scene.Node;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;

public class CalcPublicUserView{
    private static CalcPublicUserView instance;

    private String[] categories = { "Personal Transportation (Electrical)", "Personal Transportation (Non-electrical)",
                                    "Air Travel", "Home Energy"};
    private double[] emissionFactors = {0.08, 0.12, 0.25, 0.5};
    private double[][] emissionData = new double[5][2];
    Stage stage = new Stage();
    Admin admin = new Admin();
    UserManagement userManagement = UserManagement.getInstance();
    
    public void CalcPublicUserView(){
        if(userManagement.getUser().equals(admin.getAdminName())){
            CalcAdminView.getInstance().CalcAdminView();
        }else{
            displayCalculator(stage);
        }
    }
    
    public static CalcPublicUserView getInstance() {
        if (instance == null) {
            instance = new CalcPublicUserView();
        }
        return instance;
    }
    
    public void displayCalculator(Stage primaryStage)
    {
        primaryStage.setTitle("Greenhub CO2 Calculator");
        
        // UI SECTION //

        //title
        Label helloUserTitle = new Label("Hello, User!");
        helloUserTitle.setStyle("-fx-font-family: Verdana; -fx-text-fill: black; -fx-font-size: 20px;");
       
        //subtitle (select your...)
        Label selectTitle = new Label("Select a category to get started.");
        selectTitle.setStyle("-fx-font-family: Verdana; -fx-text-fill: black; -fx-font-size: 16px;");

        VBox vb1 = new VBox();
        vb1.setSpacing(20);
        vb1.setLayoutX(180);
        vb1.setLayoutY(30);

        //title vbox
        VBox title = new VBox();
        title.setLayoutX(220);
        title.setLayoutY(205);
        title.getChildren().addAll(helloUserTitle);
        //"select your.." vbox
        VBox subtitle = new VBox();
        subtitle.setLayoutX(145);
        subtitle.setLayoutY(240);
        subtitle.getChildren().addAll(selectTitle);
        
        //categories buttons & vbox
        VBox categoriesMenu = new VBox();
        categoriesMenu.setSpacing(5);
        categoriesMenu.setPadding(new Insets(30));
        categoriesMenu.setLayoutX(95);
        categoriesMenu.setLayoutY(260);
        //For loop for looping in the categories 
        for (String category : categories)
        {
            Button categoryButton = new Button(category);
            //Switch statement 
            switch (category)
            {
                case "Personal Transportation (Electrical)":
                    categoryButton.setStyle("-fx-background-color: #5F9EA0; -fx-text-fill: white; -fx-font-size: 14px;");
                    categoryButton.setOnAction(e -> handleCategorySelection(category, primaryStage));
                    categoryButton.setPrefSize(300, 30);
                    break;
                case "Personal Transportation (Non-electrical)":
                    categoryButton.setStyle("-fx-background-color: #6CACAF; -fx-text-fill: white; -fx-font-size: 14px;");
                    categoryButton.setOnAction(e -> handleCategorySelection(category, primaryStage));
                    categoryButton.setPrefSize(300, 30);
                    break;
                case "Air Travel":
                    categoryButton.setStyle("-fx-background-color: #79BBBD; -fx-text-fill: white; -fx-font-size: 14px;");
                    categoryButton.setOnAction(e -> handleCategorySelection(category, primaryStage));
                    categoryButton.setPrefSize(300, 30);
                    break;
                case "Home Energy":
                    categoryButton.setStyle("-fx-background-color: #93D7DA; -fx-text-fill: white; -fx-font-size: 14px;");
                    categoryButton.setOnAction(e -> handleCategorySelection(category, primaryStage));
                    categoryButton.setPrefSize(300, 30);
                    break;
                default:
                    categoryButton.setStyle("-fx-background-color: CADETBLUE; -fx-text-fill: white; -fx-font-size: 14px;");
                    categoryButton.setOnAction(e -> handleCategorySelection(category, primaryStage));
                    categoryButton.setPrefSize(300, 30);
            }

            categoriesMenu.getChildren().addAll(categoryButton);
        }

        //borderpanes
        BorderPane borderPane = new BorderPane();
        Navigation navBar = new Navigation(primaryStage, borderPane);
        borderPane.setLeft(navBar);
        navBar.setAlignment(Pos.CENTER);
        //pane
        Pane pane = new Pane();
        pane.getChildren().addAll(vb1, title, subtitle, categoriesMenu);
        pane.setPadding(new Insets(20));
        pane.setStyle("-fx-background-color: azure");
        borderPane.setCenter(pane);
      
        //scene section, displaying all
        Scene scene = new Scene(borderPane, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
    }
    
    // New page after selecting category //
    
    private void handleCategorySelection(String selectedCategory, Stage primaryStage)
    {
        Pane root = (Pane) primaryStage.getScene().getRoot();

        if (root != null)
        {
            root.getChildren().clear();
            
            BorderPane borderpane = new BorderPane();
            Navigation navBar = new Navigation(primaryStage, borderpane);
            borderpane.setLeft(navBar);
            navBar.setAlignment(Pos.CENTER);
            
            Label title = new Label(selectedCategory);
            title.setStyle("-fx-font-family: Verdana; -fx-text-fill: black; -fx-font-size: 16px;");
            Label message1 = new Label();
            Label message2 = new Label();
            message1.setStyle("-fx-text-fill: black; -fx-font-size: 16px;");
            message2.setStyle("-fx-text-fill: black; -fx-font-size: 14px; -fx-alignment: center;"); 
            
                switch (selectedCategory)
                {
                    case "Personal Transportation (Electrical)":
                    case "Personal Transportation (Non-electrical)":
                        message1.setText("How many kilometres have you travelled today?\n");
                        message2.setText("(Example: 50 kilometres)");
                        break;
                    case "Air Travel":
                        message1.setText("How many kilometres have you flown today?");
                        message2.setText("(Example: Kuala Lumpur to Penang - 325 kilometres)");
                        break;
                    case "Home Energy":
                        message1.setText("How much energy have you used today?");
                        message2.setText("(Example: 80 kilowatt-hours)");
                        break;
                    default:
                        message1.setText("How much CO2 have you produced today?\n(in kg):");
                }

            TextField valueField = new TextField();
            valueField.setPrefSize(125,25);
            Button calculateButton = new Button("Calculate");
            calculateButton.setStyle("-fx-font-family: Verdana; -fx-background-color: CADETBLUE; -fx-text-fill: white; -fx-font-size: 16px;");
            Label resultLabel = new Label();
            resultLabel.setMaxWidth(125);

            calculateButton.setOnAction(e -> handleCalculate(selectedCategory, valueField.getText()));

            //pane's content
            VBox content = new VBox();
            content.setStyle("-fx-background-color: azure");
            content.setSpacing(10);
            HBox buttons = new HBox();
            buttons.getChildren().addAll(calculateButton, backButton1(primaryStage));
            buttons.setSpacing(100);
            content.getChildren().addAll(title, message1, message2, valueField, buttons);
            VBox result = new VBox();
            result.getChildren().add(resultLabel);
            result.setPadding(new Insets(200,0,0,0));
            content.setAlignment(Pos.CENTER);
            
            //mini pane (x - -left +right, y - -top +bottom)
            Pane miniPane = new Pane();
            miniPane.setStyle("-fx-background-color: azure");
            miniPane.setPrefWidth(500);
            
            miniPane.getChildren().addAll(content, result);
            
            borderpane.setCenter(miniPane);
            BorderPane.setMargin(miniPane, new Insets(100, 0, 0, 110));
            borderpane.setStyle("-fx-background-color: azure");
            
            Scene scene = new Scene(borderpane, 800, 600);
            primaryStage.setScene(scene);
            primaryStage.show();
            primaryStage.setResizable(false);
        }
    }    
    
    // METHODS SECTION //

    private void handleCalculate(String category, String valueText){
    Alert alert;
    try
    {
        double value = Double.parseDouble(valueText);
        int categoryIndex = getCategoryIndex(category);
        double emission = value * emissionFactors[categoryIndex];
        double weeklyAverage;

        emissionData[categoryIndex][0] += emission;
        emissionData[categoryIndex][1]++;

        weeklyAverage = calculateWeeklyAverage();

        //default message
        String resultContent = "Limit: " + CalcAdminView.getWeeklyLimit() + " kgCO2\n" +
                                  "Estimated emissions: " + emission + " kgCO2\n" +
                                  "Weekly average: " + weeklyAverage + " kgCO2\n";

        // Create the alert
        

        try
        {
            //If statement 
            if (weeklyAverage > CalcAdminView.getWeeklyLimit())
            {  
                //bad!
                resultContent += "\nYour carbon emission has surpassed the weekly limit!\nPlease reduce your footprint.";
                alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Calculation Results");
                FileInputStream smiley1 = new FileInputStream("src/images/badSmiley.png");
                Image image = new Image(smiley1);
                ImageView bad = new ImageView(image);               
                bad.setFitWidth(50);
                bad.setFitHeight(50);
                alert.setGraphic(bad);
            }
            else
                if (weeklyAverage <= CalcAdminView.getWeeklyLimit() && weeklyAverage >= (CalcAdminView.getWeeklyLimit() * 0.75))
                {
                    //okay...
                    resultContent += "\nYour carbon emission is almost at an alarming rate. Consider reducing your footprint.";
                    alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Calculation Results");
                    FileInputStream smiley2 = new FileInputStream("src/images/okaySmiley.png");
                    Image image = new Image(smiley2);
                    ImageView okay = new ImageView(image);               
                    okay.setFitWidth(50);
                    okay.setFitHeight(50);
                    alert.setGraphic(okay);
                }
                else
                {
                    //yay!
                    resultContent += "\nYour carbon emission is low. Keep it up!";
                    alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Calculation Results");
                    FileInputStream smiley3 = new FileInputStream("src/images/goodSmiley.png");
                    Image image = new Image(smiley3);
                    ImageView good = new ImageView(image);               
                    good.setFitWidth(50);
                    good.setFitHeight(50);
                    alert.setGraphic(good);
                }

            alert.setHeaderText(null);
            alert.setContentText(resultContent);

            //setwraptext part
            DialogPane dialogPane = alert.getDialogPane();

            for (Node node : dialogPane.getChildren())
            {
                if (node instanceof Label)
                {
                    Label content = (Label) node;
                    content.setWrapText(true);
                }
            }

            alert.showAndWait();
        }
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        }
     }
    catch (NumberFormatException ignored)
    {
        String oops = "Please enter a valid number.";
        alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(oops);
        alert.showAndWait();
        
    } 
   }

    private int getCategoryIndex(String category)
    {
        for (int i = 0; i < categories.length; i++)
        {
            if (categories[i].equals(category))
            {
                return i;
            }
        }
        return -1;
    }

    private double calculateWeeklyAverage()
    {
        double totalEmissions = 0;
        double totalEntries = 0;

        for (double[] entry : emissionData)
        {
            double emissionsForCategory = entry[0];
            double entriesForCategory = entry[1];

            totalEmissions += emissionsForCategory;
            totalEntries += entriesForCategory;
        }

        double weeklyAverage = totalEntries > 0 ? totalEmissions / totalEntries / 7 : 0;
        
        // Round to the nearest two decimal places
        weeklyAverage = Math.round(weeklyAverage * 100.0) / 100.0;

        return weeklyAverage;
    }
    
    private Button backButton1(Stage primaryStage)
    {
        Button goBackButton = new Button("Go Back");
        goBackButton.setStyle("-fx-font-family: Verdana; -fx-background-color: CADETBLUE; -fx-text-fill: white; -fx-font-size: 16px;");
        goBackButton.setOnAction(e -> displayCalculator(primaryStage));
        return goBackButton;
    }

}