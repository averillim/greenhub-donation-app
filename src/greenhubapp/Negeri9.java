/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package greenhubapp;

import javafx.scene.image.Image;

/**
 *
 * @author User
 */
public class Negeri9 extends States implements Region{

    public Negeri9(String stateName, int carbonEmission, int levelAPI, int hazePercent) {
        super(stateName, carbonEmission, levelAPI, hazePercent);
    }
    
    @Override
    public uiView[] getNoButtons() {
        uiView[] buttonsList = {};
        
        return buttonsList;
    }

    @Override
    public uiView[] getLightButtons() {
        Image smallLightHaze1 = new Image("Images/S1_5.PNG.png");
        uiView Haze1View = new uiView(smallLightHaze1, 300, 450, 120, 120, true);  
        
        uiView[] buttonsList = {Haze1View};
        
        return buttonsList;
    }

    @Override
    public uiView[] getMediumButtons() {
        Image smallLightHaze1 = new Image("Images/S2_4.PNG.png");
        uiView Haze1View = new uiView(smallLightHaze1, 300, 450, 120, 120, true);  
        
        uiView[] buttonsList = {Haze1View};
        
        return buttonsList;
    }

    @Override
    public uiView[] getHeavyButtons() {
        Image smallLightHaze1 = new Image("Images/S3_4.PNG.png");
        uiView Haze1View = new uiView(smallLightHaze1, 300, 450, 120, 120, true);  
        
        uiView[] buttonsList = {Haze1View};
        
        return buttonsList;
    }

    
    
}
