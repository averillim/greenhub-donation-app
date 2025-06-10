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
public class Terengganu extends States implements Region{
    
    public Terengganu(String stateName, int carbonEmission, int levelAPI, int hazePercent) {
        super(stateName, carbonEmission, levelAPI, hazePercent);
    }
    
    public uiView[] getNoButtons(){
        uiView[] buttonsList = {};
        
        return buttonsList;
    }
    
    public uiView[] getLightButtons(){
        Image smallLightHaze1 = new Image("Images/S1_5.PNG.png");
        uiView Haze1View = new uiView(smallLightHaze1, 360, 100, 150, 150, true);  
            
        Image smallLightHaze2 = new Image("Images/S1_4.PNG.png");
        uiView Haze2View = new uiView(smallLightHaze2, 400, 190, 150, 150, true);
        
        Image smallLightHaze3 = new Image("Images/S1_3.PNG.png");
        uiView Haze3View = new uiView(smallLightHaze3, 450, 190, 150, 150, true);
        
        Image smallLightHaze4 = new Image("Images/S1_2.PNG.png");
        uiView Haze4View = new uiView(smallLightHaze4, 400, 150, 150, 150, true);
        
        uiView[] buttonsList = {Haze1View, Haze2View, Haze3View, Haze4View};
        
        return buttonsList;
    }
    
    public uiView[] getMediumButtons(){
        Image smallLightHaze1 = new Image("Images/S2_5.PNG.png");
        uiView Haze1View = new uiView(smallLightHaze1, 360, 100, 150, 150, true);  
            
        Image smallLightHaze2 = new Image("Images/S2_4.PNG.png");
        uiView Haze2View = new uiView(smallLightHaze2, 400, 190, 150, 150, true);
        
        Image smallLightHaze3 = new Image("Images/S2_3.PNG.png");
        uiView Haze3View = new uiView(smallLightHaze3, 400, 190, 150, 150, true);
        
        Image smallLightHaze4 = new Image("Images/S2_2.PNG.png");
        uiView Haze4View = new uiView(smallLightHaze4, 430, 150, 150, 150, true);
        
        uiView[] buttonsList = {Haze1View, Haze2View, Haze3View, Haze4View};
        
        return buttonsList;
    }
    
    public uiView[] getHeavyButtons(){
        Image smallLightHaze1 = new Image("Images/S3_5.PNG.png");
        uiView Haze1View = new uiView(smallLightHaze1, 360, 100, 150, 150, true);  
            
        Image smallLightHaze2 = new Image("Images/S3_4.PNG.png");
        uiView Haze2View = new uiView(smallLightHaze2, 400, 190, 150, 150, true);
        
        Image smallLightHaze3 = new Image("Images/S3_3.PNG.png");
        uiView Haze3View = new uiView(smallLightHaze3, 400, 190, 150, 150, true);
        
        Image smallLightHaze4 = new Image("Images/S3_2.PNG.png");
        uiView Haze4View = new uiView(smallLightHaze4, 430, 150, 150, 150, true);
        
        uiView[] buttonsList = {Haze1View, Haze2View, Haze3View, Haze4View};
        
        return buttonsList;
    }
    
}
