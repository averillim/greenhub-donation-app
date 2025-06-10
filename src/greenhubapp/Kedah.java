package greenhubapp;

import javafx.scene.image.Image;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class Kedah extends States implements Region{
    
    public Kedah(String stateName, int carbonEmission, int levelAPI, int hazePercent) {
        super(stateName, carbonEmission, levelAPI, hazePercent);
    }
    
    public uiView[] getNoButtons(){
        uiView[] buttonsList = {};
        
        return buttonsList;
    }
    
    public uiView[] getLightButtons(){
        Image smallLightHaze1 = new Image("Images/S1_5.PNG.png");
        uiView Haze1View = new uiView(smallLightHaze1, 80, 30, 100, 100, true);  
            
        Image smallLightHaze2 = new Image("Images/S1_4.PNG.png");
        uiView Haze2View = new uiView(smallLightHaze2, 70, 70, 100, 100, true);
        
        Image smallLightHaze3 = new Image("Images/S1_3.PNG.png");
        uiView Haze3View = new uiView(smallLightHaze3, 105, 50, 100, 100, true);
        
        Image smallLightHaze4 = new Image("Images/S1_2.PNG.png");
        uiView Haze4View = new uiView(smallLightHaze4, 130, 90, 100, 100, true);
        
        uiView[] buttonsList = {Haze1View, Haze2View, Haze3View, Haze4View};
        
        return buttonsList;
    }
    
    public uiView[] getMediumButtons(){
        Image smallLightHaze1 = new Image("Images/S2_5.PNG.png");
        uiView Haze1View = new uiView(smallLightHaze1, 80, 30, 100, 100, true);  
            
        Image smallLightHaze2 = new Image("Images/S2_4.PNG.png");
        uiView Haze2View = new uiView(smallLightHaze2, 70, 70, 100, 100, true);
        
        Image smallLightHaze3 = new Image("Images/S2_3.PNG.png");
        uiView Haze3View = new uiView(smallLightHaze3, 105, 50, 100, 100, true);
        
        Image smallLightHaze4 = new Image("Images/S2_2.PNG.png");
        uiView Haze4View = new uiView(smallLightHaze4, 130, 90, 100, 100, true);
        
        uiView[] buttonsList = {Haze1View, Haze2View, Haze3View, Haze4View};
        
        return buttonsList;
    }
    
    public uiView[] getHeavyButtons(){
        Image smallLightHaze1 = new Image("Images/S3_5.PNG.png");
        uiView Haze1View = new uiView(smallLightHaze1, 80, 30, 100, 100, true);  
            
        Image smallLightHaze2 = new Image("Images/S3_4.PNG.png");
        uiView Haze2View = new uiView(smallLightHaze2, 70, 70, 100, 100, true);
        
        Image smallLightHaze3 = new Image("Images/S3_3.PNG.png");
        uiView Haze3View = new uiView(smallLightHaze3, 105, 50, 100, 100, true);
        
        Image smallLightHaze4 = new Image("Images/S3_2.PNG.png");
        uiView Haze4View = new uiView(smallLightHaze4, 130, 90, 100, 100, true);
        
        uiView[] buttonsList = {Haze1View, Haze2View, Haze3View, Haze4View};
        
        return buttonsList;
    }
    
}
