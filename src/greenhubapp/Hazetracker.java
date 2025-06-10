package greenhubapp;

import java.io.FileInputStream;
import java.util.*;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;


public abstract class Hazetracker extends Application {
    private static Hazetracker instance;
    
// Create all containers for the contents
    public Stage stage;
    public BorderPane root;
    VBox buttonVBox = new VBox();
    VBox baseRectangle = new VBox();
    StackPane rightTab = new StackPane();

    Admin AdminClass = new Admin();
    String admin = AdminClass.getAdminName();
    uiView[] selangorHaze, perakHaze, kelantanHaze, kedahHaze, pahangHaze, johorHaze, negeri9Haze, terengganuHaze, melakaHaze, sabahHaze, sarawakHaze;
    Group mapContent = new Group();
    FlowPane fPane = new FlowPane();
 
    Image map = new Image("Images/malaysia_2.png");
    ImageView mapView = new ImageView(map);
    
    HazeCustomButton[] choiceButton;

// Instantiate all the states region classes
    Selangor selangor = new Selangor("Selangor", 62, 75, 0);
    Perak perak = new Perak("Perak", 22, 53, 0);
    Kedah kedah = new Kedah("Kedah", 19, 52, 0);
    Kelantan kelantan = new Kelantan("Kelantan", 16, 41, 0);
    Pahang pahang = new Pahang("Pahang", 14, 35, 100);
    Johor johor = new Johor("Johor", 35,56, 100);
    Negeri9 negeri9 = new Negeri9("Negeri Sembilan", 10, 39, 0);
    Terengganu terengganu = new Terengganu("Terengganu", 10, 39, 0);
    Melaka melaka = new Melaka("Melaka", 9, 53, 0);
    Sabah sabah = new Sabah("Sabah", 31, 32, 0);
    Sarawak sarawak = new Sarawak("Sarawak", 21, 43, 0);

// Applying an interface region for the states
    Region rselangor = selangor;
    Region rkelantan = kelantan;
    Region rjohor = johor;
    Region rpahang = pahang;
    Region rperak = perak;
    Region rkedah = kedah;
    Region rnegeri9 = negeri9;
    Region rterengganu = terengganu;
    Region rmelaka = melaka;
    Region rsabah = sabah;
    Region rsarawak = sarawak;
    
    ScrollPane scrP = new ScrollPane();
    
    public void Hazetracker(){
        stage = new Stage();
        stage.setScene(getHazeScene());
        stage.setResizable(false);
        stage.setMaximized(true);
        stage.show(); 
     }
   
    public static Hazetracker getInstance() {
        if (instance == null) {
            instance = new Hazetracker() {
                @Override
                public void start(Stage primaryStage) throws Exception {
                    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                }
            };
        }
        return instance;
    }

    public Scene getHazeScene(){
        try{
            // Setting up page layouts and scenes
            root = new BorderPane();
            buttonVBox.setSpacing(45);
            buttonVBox.setPadding(new Insets(20,0,0,0));
            Scene scene = new Scene(root, 1720, 990);

            Rectangle rectangle = new Rectangle();
            rectangle.setX(1520);
            rectangle.setY(0);
            rectangle.setWidth(200);
            rectangle.setHeight(1100);
            rectangle.setArcHeight(35);
            rectangle.setArcWidth(35);
            rectangle.setFill(Color.rgb(8, 52, 52));
            rectangle.setStrokeWidth(3);
            rectangle.setStroke(Color.GREEN);
            // Making a refresh button that reloads all the images on screen
            Button rButton = new Button("Refresh");
            rButton.setOnAction((ActionEvent event) -> {
                refresh();
            });
            rButton.setLayoutX(620);
            rButton.setLayoutY(550);
            rButton.setPrefWidth(200);
            rButton.setPrefHeight(60);
            
            root.getChildren().addAll(fPane);
            
            choiceButton = getChoiceButtons();
            //loading all states choice button
            for (Button i: choiceButton){
                buttonVBox.getChildren().add(i);
            }
            baseRectangle.getChildren().add(rectangle);
            buttonVBox.getChildren().add(rButton);
            VBox.setMargin(rButton, new Insets(50, 0, 0, 0));
            rightTab.getChildren().addAll(baseRectangle, buttonVBox);
            root.setRight(rightTab);
            //starting the stages
            refresh();
            
            Navigation navBar = new Navigation(stage, root);
            root.setLeft(navBar);
            navBar.setAlignment(Pos.CENTER);
            return scene;
            
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
        
    }
    //Generating all the transition for the images
    public ArrayList<fadeTransitionWrap> generateFD(uiView[] ViewList){
        ArrayList<fadeTransitionWrap> fdList = new ArrayList<fadeTransitionWrap>();
        int index = 1;
        for (uiView i : ViewList){
            if (index%3 == 1){
                fadeTransitionWrap fd = new fadeTransitionWrap(Duration.seconds(2), 1.3, 0.5, i);
                fdList.add(fd);
                index++;
            } else if (index%3 == 2) {
                fadeTransitionWrap fd = new fadeTransitionWrap(Duration.seconds(1.5), 0.5, 1.3, i);
                fdList.add(fd);
                index++;
            } else {
                fadeTransitionWrap fd = new fadeTransitionWrap(Duration.seconds(1.5), 1.3, 0.5, i);
                fdList.add(fd);
                index++;
            }
        }
        
        return fdList;
    }
    //Generating the haze cloud colors based on haze intensity
    public uiView[] getViews(Region region, int level){
        uiView[] rViews;
        //Switch case 
        switch (level) {
                case 1:
                    rViews = region.getNoButtons();
                    break;
                case 2:
                    rViews = region.getLightButtons();
                    break;
                case 3:
                    rViews = region.getMediumButtons();
                    break;
                case 4:
                    rViews = region.getHeavyButtons();
                    break;
                default:
                    throw new AssertionError();
            }
        return rViews;
    }
    
    public void insertChild(uiView[] uiViews){
        for (ImageView i : uiViews){
            mapContent.getChildren().add(i);
        }
    }
    //Reloading all clouds
    public void refresh(){
        mapContent.getChildren().clear();
        fPane.getChildren().clear();
        fPane.setPadding(new Insets(55,55,55,55));
        fPane.setHgap(10);
        fPane.setVgap(10);
        fPane.setLayoutX(190);
        fPane.setLayoutY(-56);
        ObservableList<Node> fPaneControls = fPane.getChildren(); 

        selangorHaze = getViews(selangor, selangor.getHazeLevel());
        perakHaze = getViews(perak, perak.getHazeLevel());
        kedahHaze = getViews(kedah, kedah.getHazeLevel());
        kelantanHaze = getViews(kelantan, kelantan.getHazeLevel());
        pahangHaze = getViews(pahang, pahang.getHazeLevel());
        johorHaze = getViews(johor, johor.getHazeLevel());
        negeri9Haze = getViews(negeri9, negeri9.getHazeLevel());
        terengganuHaze = getViews(terengganu, terengganu.getHazeLevel());
        melakaHaze = getViews(melaka, melaka.getHazeLevel());
        sabahHaze = getViews(sabah, sabah.getHazeLevel());
        sarawakHaze = getViews(sarawak, sarawak.getHazeLevel());

        mapContent.getChildren().addAll(mapView);
        
        //Creating an arraylist
        ArrayList<fadeTransitionWrap>allList = new ArrayList<fadeTransitionWrap>();
        allList.addAll(generateFD(selangorHaze));
        allList.addAll(generateFD(perakHaze));
        allList.addAll(generateFD(kedahHaze));
        allList.addAll(generateFD(kelantanHaze));
        allList.addAll(generateFD(pahangHaze));
        allList.addAll(generateFD(johorHaze));
        allList.addAll(generateFD(negeri9Haze));
        allList.addAll(generateFD(terengganuHaze));
        allList.addAll(generateFD(melakaHaze));
        allList.addAll(generateFD(sabahHaze));
        allList.addAll(generateFD(sarawakHaze));

        insertChild(selangorHaze);
        insertChild(perakHaze);
        insertChild(kedahHaze);
        insertChild(kelantanHaze);
        insertChild(pahangHaze);
        insertChild(johorHaze);
        insertChild(negeri9Haze);
        insertChild(terengganuHaze);
        insertChild(melakaHaze);
        insertChild(sabahHaze);
        insertChild(sarawakHaze);
        
        HazeCustomButton bSelangor = new HazeCustomButton(200, 380, 150, 100, 0, rselangor, admin);
        HazeCustomButton bKelantan = new HazeCustomButton(280, 100, 150, 100, 0, rkelantan, admin);
        HazeCustomButton bJohor = new HazeCustomButton(430, 500, 150, 200, 0, rjohor, admin);
        HazeCustomButton bPahang = new HazeCustomButton(300, 300, 150, 200, 0, rpahang, admin);
        HazeCustomButton bPerak = new HazeCustomButton(140, 160, 200, 100, 0, rperak, admin);
        HazeCustomButton bKedah = new HazeCustomButton(90, 40, 150, 100, 0, rkedah, admin);
        HazeCustomButton bNegeri9 = new HazeCustomButton(300, 450, 70, 100, 0, rnegeri9, admin);
        HazeCustomButton bTerengganu = new HazeCustomButton(410, 100, 200, 100, 0, rterengganu, admin);
        HazeCustomButton bMelaka = new HazeCustomButton(330, 530, 50, 70, 0, rmelaka, admin);
        HazeCustomButton bSabah = new HazeCustomButton(650, 700, 300, 800, 0, rsabah, admin);
        HazeCustomButton bSarawak = new HazeCustomButton(1400, 320, 300, 300, 0, rsarawak, admin);
        
        mapContent.getChildren().addAll(bSelangor, bKelantan, bJohor, bPahang, bPerak, bKedah, bNegeri9, bTerengganu);
        mapContent.getChildren().addAll(bMelaka, bSabah, bSarawak);
        
        scrP.setPrefSize(1408, 1115);
        scrP.setContent(mapContent);
        fPaneControls.addAll(scrP);
        
        for (fadeTransitionWrap i : allList){
            i.playFromStart();
        }
    }
    // creating all states button
    public HazeCustomButton[] getChoiceButtons(){
        HazeCustomButton[] choiceButtons;
        
        HazeCustomButton selangor = new HazeCustomButton(620, 30, 30, 200, 1, rselangor, admin);
        selangor.setText("Selangor");
        HazeCustomButton perak = new HazeCustomButton(620, 75, 30, 200, 1, rperak, admin);
        perak.setText("Perak");
        HazeCustomButton kedah = new HazeCustomButton(620, 120, 30, 200, 1, rkedah, admin);
        kedah.setText("Kedah");
        HazeCustomButton kelantan = new HazeCustomButton(620, 165, 30, 200, 1, rkelantan, admin);
        kelantan.setText("Kelantan");
        HazeCustomButton melaka = new HazeCustomButton(620, 210, 30, 200, 1, rmelaka, admin);
        melaka.setText("Melaka");
        HazeCustomButton pahang = new HazeCustomButton(620, 255, 30, 200, 1, rpahang, admin);
        pahang.setText("Pahang");
        HazeCustomButton negeri9 = new HazeCustomButton(620, 300, 30, 200, 1, rnegeri9, admin);
        negeri9.setText("Negeri Sembilan");
        HazeCustomButton terengganu = new HazeCustomButton(620, 345, 30, 200, 1, rterengganu, admin);
        terengganu.setText("Terengganu");
        HazeCustomButton johor = new HazeCustomButton(620, 390, 30, 200, 1, rjohor, admin);
        johor.setText("Johor");
        HazeCustomButton sabah = new HazeCustomButton(620, 435, 30, 200, 1, rsabah, admin);
        sabah.setText("Sabah");
        HazeCustomButton sarawak = new HazeCustomButton(620, 480, 30, 200, 1, rsarawak, admin);
        sarawak.setText("Sarawak");
        
        choiceButtons = new HazeCustomButton[]{selangor, perak, kedah, kelantan, melaka, pahang, negeri9, terengganu, johor, sabah, sarawak};
        
        return choiceButtons;
    }
}