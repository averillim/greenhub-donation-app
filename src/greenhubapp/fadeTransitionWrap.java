/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package greenhubapp;

import javafx.animation.FadeTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 *
 * @author User
 */
public class fadeTransitionWrap{
    private final FadeTransition fadeTransition;
    
    public fadeTransitionWrap(Duration duration, double fromValue, double toValue, ImageView image){
        fadeTransition = new FadeTransition(duration, image);
        fadeTransition.setFromValue(fromValue);
        fadeTransition.setToValue(toValue);
        fadeTransition.setCycleCount(FadeTransition.INDEFINITE);
        fadeTransition.setAutoReverse(true);
    }

    void playFromStart() {
        fadeTransition.playFromStart();
    }
}
