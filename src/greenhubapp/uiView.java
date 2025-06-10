/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package greenhubapp;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author User
 */
public class uiView extends ImageView{
    
    public uiView(Image image, int setX, int setY, int fitHeight, int fitWidth, boolean preserveRatio){
        super(image);
        this.setX(setX);
        this.setY(setY);
        this.setFitHeight(fitHeight);
        this.setFitWidth(fitWidth);
        this.setPreserveRatio(preserveRatio);
    }
}
