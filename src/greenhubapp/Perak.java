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
public class Perak extends States implements Region{
    
    public Perak(String stateName, int carbonEmission, int levelAPI, int hazePercent) {
        super(stateName, carbonEmission, levelAPI, hazePercent);
    }
    
    public uiView[] getNoButtons(){
        uiView[] buttonsList = {};
        
        return buttonsList;
    }
    
    public uiView[] getLightButtons(){
        Image smallLightHaze1 = new Image("Images/B1_4.PNG.png");
        uiView Haze1View = new uiView(smallLightHaze1, 140, 100, 150, 150, true);  
            
        Image smallLightHaze2 = new Image("Images/B1_2.PNG.png");
        uiView Haze2View = new uiView(smallLightHaze2, 100, 180, 150, 150, true);
        
        Image smallLightHaze3 = new Image("Images/B1_3.PNG.png");
        uiView Haze3View = new uiView(smallLightHaze3, 130, 145, 150, 150, true);
        
        Image smallLightHaze4 = new Image("Images/B1_1.PNG.png");
        uiView Haze4View = new uiView(smallLightHaze4, 120, 230, 150, 150, true);
        
        uiView[] buttonsList = {Haze1View, Haze2View, Haze3View, Haze4View};
        
        return buttonsList;
    }
    
    public uiView[] getMediumButtons(){
        Image smallLightHaze1 = new Image("Images/B2_4.PNG.png");
        uiView Haze1View = new uiView(smallLightHaze1, 140, 100, 150, 150, true);  
            
        Image smallLightHaze2 = new Image("Images/B2_2.PNG.png");
        uiView Haze2View = new uiView(smallLightHaze2, 100, 180, 150, 150, true);
        
        Image smallLightHaze3 = new Image("Images/B2_3.PNG.png");
        uiView Haze3View = new uiView(smallLightHaze3, 130, 145, 150, 150, true);
        
        Image smallLightHaze4 = new Image("Images/B2_1.PNG.png");
        uiView Haze4View = new uiView(smallLightHaze4, 120, 230, 150, 150, true);
        
        uiView[] buttonsList = {Haze1View, Haze2View, Haze3View, Haze4View};
        
        return buttonsList;
    }
    
    public uiView[] getHeavyButtons(){
        Image smallLightHaze1 = new Image("Images/B3_4.PNG.png");
        uiView Haze1View = new uiView(smallLightHaze1, 140, 100, 150, 150, true);  
            
        Image smallLightHaze2 = new Image("Images/B3_2.PNG.png");
        uiView Haze2View = new uiView(smallLightHaze2, 100, 180, 150, 150, true);
        
        Image smallLightHaze3 = new Image("Images/B3_3.PNG.png");
        uiView Haze3View = new uiView(smallLightHaze3, 130, 145, 150, 150, true);
        
        Image smallLightHaze4 = new Image("Images/B3_1.PNG.png");
        uiView Haze4View = new uiView(smallLightHaze4, 120, 280, 150, 150, true);
        
        uiView[] buttonsList = {Haze1View, Haze2View, Haze3View, Haze4View};
        
        return buttonsList;
    }
}
