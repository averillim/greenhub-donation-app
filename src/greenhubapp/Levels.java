package greenhubapp;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author abila
 */
public class Levels{     
    private Scene scene;
    private Stage stage;
    public BorderPane root;
    
    private Scene scenepass;
    private Scene scenecomplete;
    
    //Scene before starting the game
    public void GetReady(){
        stage = new Stage();
        StackPane readyRoot = new StackPane();
        BorderPane readyLayout = new BorderPane();
        
        scene = new Scene(readyLayout, 800, 600,Color.AZURE);  
        readyLayout.setBackground(new Background(new BackgroundFill(Color.AZURE, CornerRadii.EMPTY, Insets.EMPTY)));
        
        Label readytext = new Label(" Ready? ");
        readytext.setFont(Font.font("Tahoma",65));
      
        
        Rectangle rec = new Rectangle(800,600,Color.TRANSPARENT);
        readyRoot.getChildren().addAll(readytext,rec);
        
        rec.setOnMouseEntered((javafx.scene.input.MouseEvent event) -> {
            int x = 2;
            try{
                //A do-while loop acting as a timer 
                do{
                    Thread.sleep(1000);
                    x--;
                }while(x >0);
                readyRoot.getChildren().remove(rec);
                
                startlevelOne(stage);
                
            }   catch (InterruptedException ex) {}
        }); 
        
        readyLayout.setCenter(readyRoot);
        stage.setTitle("Get Ready! ");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    
    //Scene after passing Level 1
    public void Lv1Pass(){
        GameButtons mybtn = new GameButtons();
        stage = new Stage();
        root = new BorderPane();
        Group passLayout = new Group();
        VBox levelInfo = new VBox();
        
        scenepass = new Scene(root, 800, 600); 
        
        Image image = new Image("Images/levelonebg.jpg");
        ImageView mv = new ImageView(image);
        mv.setOpacity(0.67);
        
        StackPane stackPass = new StackPane();
        
        Rectangle passborder = new Rectangle(550,120,Color.CADETBLUE);
        passborder.setArcHeight(33);
        passborder.setArcWidth(33);

        Label passtext = new Label(" Level 1 Completed ");
        passtext.setTextFill(Color.WHITE);
        passtext.setWrapText(true);
        passtext.setFont(Font.font("Tahoma",65));

        stackPass.getChildren().addAll(passborder,passtext);
        stackPass.setAlignment(passtext,Pos.CENTER);
        
        StackPane stackInfo = new StackPane();
        
        Label textInfo = new Label("Drinking water supply requires energy,which in turn emits\ngreenhouse gases with undesirable climate impacts.\nWater conservation, therefore, offers environmental benefits by reducing such emissions. ");
        textInfo.setTextFill(Color.WHITE);
        textInfo.setFont(Font.font("Tahoma",15));
        textInfo.setWrapText(true);
        textInfo.setPadding(new Insets(20, 20, 20, 20));
        
        Rectangle contborder = new Rectangle(650,120,Color.CADETBLUE);
        contborder.setArcHeight(33);
        contborder.setArcWidth(33);

        stackInfo.getChildren().addAll(contborder,textInfo);
 
        levelInfo.getChildren().addAll(stackPass, stackInfo);
        levelInfo.setSpacing(20);
        levelInfo.setPadding(new Insets(70, 70, 20, 70));
        levelInfo.setAlignment(Pos.CENTER);
        
        passLayout.getChildren().addAll(mv,levelInfo);
        
        mybtn.toGameDash(passLayout, stage,25,150,450,200,50);
        mybtn.toLv2(passLayout, stage, 450, 450, 200, 50);
        root.setCenter(passLayout);
        stage.setTitle("Level 1 Completed");
        stage.setScene(scenepass);
        stage.setResizable(false);
        stage.show();
        
    }
    //Scene after completing the levels
    public void Complete(){
        GameButtons mybtn = new GameButtons();
        stage = new Stage();
        root = new BorderPane();
        Group completelayout = new Group();
        VBox levelInfo = new VBox();
        Image imageLv2 = new Image("Images/leveltwobg.jpg");
        ImageView mvLv2 = new ImageView(imageLv2);
        mvLv2.setOpacity(0.67);

        scenecomplete = new Scene(root, 800, 600);  
        
        StackPane compStack = new StackPane();
        
        Label passtext = new Label(" Level 2 Completed");        
        passtext.setFont(Font.font("Tahoma",65));
        passtext.setTextFill(Color.WHITE);
        passtext.setWrapText(true);
        
        Rectangle passborder = new Rectangle(650,120,Color.CADETBLUE);
        passborder.setArcHeight(33);
        passborder.setArcWidth(33);
        
        compStack.getChildren().addAll(passborder,passtext);
        StackPane.setAlignment(passtext,Pos.CENTER);
        
        StackPane stackInfo = new StackPane();
        
        Label morelevels = new Label("""
                                     Nearly 70% of residential CO2 emissions come from electricity
                                     generation. As lighting accounts for nearly 10% of residential electricity use.""");
        morelevels.setTextFill(Color.WHITE);
        morelevels.setWrapText(true);
        morelevels.setFont(Font.font("Tahoma",15));
        
        Rectangle moreborder = new Rectangle(550,100,Color.CADETBLUE);
        moreborder.setArcHeight(33);
        moreborder.setArcWidth(33);
        
        stackInfo.getChildren().addAll(moreborder,morelevels);
        StackPane.setAlignment(morelevels,Pos.CENTER);
        
        levelInfo.getChildren().addAll(compStack, stackInfo);
        levelInfo.setSpacing(20);
        levelInfo.setPadding(new Insets(100, 70, 20, 70));
        levelInfo.setAlignment(Pos.CENTER);
        
        completelayout.getChildren().addAll(mvLv2,levelInfo);
        
        mybtn.toGameDash(completelayout, stage,25,300,400,200,50);
        root.setCenter(completelayout);
        stage.setTitle("Levels Completed");
        stage.setScene(scenecomplete);
        stage.setResizable(false);
        stage.show();
    }
    
    //Level 1
    
    public void startlevelOne(Stage primaryStage) {
        stage = primaryStage;
        Group LeveloneLayout = new Group();
        root = new BorderPane();
        Image image = new Image("Images/levelonebg.jpg");
        ImageView mv = new ImageView(image);
        
        LeveloneLayout.getChildren().add(mv);
        
        GameButtons mybtn = new GameButtons(); 
        mybtn.offbtn(primaryStage,LeveloneLayout,380,240,50,50);
        mybtn.toGameDash(LeveloneLayout, stage,15, 10, 10, 100, 50);

        Scene scene1 = new Scene(root, 800, 600);
        
        root.setTop(LeveloneLayout);
        
        stage.setTitle("Level 1");
        stage.setScene(scene1);
        stage.setResizable(false);
        stage.show();
        
        
    } 
    
    public void startlevelTwo(Stage stage){
        Stage stage2 = new Stage();
        Group leveltwoLayout = new Group();
        root = new BorderPane();
        
        Image imageLv2 = new Image("Images/leveltwobg.jpg");
        ImageView myLv2 = new ImageView(imageLv2);
        
        leveltwoLayout.getChildren().add(myLv2);


        GameButtons mybtn = new GameButtons(); 
        mybtn.OffBtnLv2(stage2,leveltwoLayout,400,0,220,10);
        
        mybtn.toGameDash(leveltwoLayout, stage2, 15,10, 10, 100, 50);
        Scene scene2 = new Scene(root,800,600);
        root.setCenter(leveltwoLayout);
        stage2.setTitle("Level 2");
        stage2.setScene(scene2);
        stage2.setResizable(false);
        stage2.show();
    }
   
}
    
   
    

