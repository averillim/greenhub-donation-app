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
public class Sarawak extends States implements Region{

    public Sarawak(String stateName, int carbonEmission, int levelAPI, int hazePercent) {
        super(stateName, carbonEmission, levelAPI, hazePercent);
    }
    
    public uiView[] getNoButtons(){
        uiView[] buttonsList = {};
        
        return buttonsList;
    }
    
    public uiView[] getLightButtons(){
        Image smallLightHaze1 = new Image("Images/B1_4.PNG.png");
        uiView Haze1View = new uiView(smallLightHaze1, 1530, 300, 270, 270, true);  
            
        Image smallLightHaze2 = new Image("Images/B1_2.PNG.png");
        uiView Haze2View = new uiView(smallLightHaze2, 1530, 350, 270, 270, true);
        
        Image smallLightHaze4 = new Image("Images/B1_1.PNG.png");
        uiView Haze4View = new uiView(smallLightHaze4, 1380, 340, 250, 250, true);
        
        Image smallLightHaze5 = new Image("Images/S1_2.PNG.png");
        uiView Haze5View = new uiView(smallLightHaze5, 1380, 420, 200, 250, true);
        
        uiView[] buttonsList = {Haze1View, Haze2View, Haze4View, Haze5View};
        
        return buttonsList;
    }
    
    public uiView[] getMediumButtons(){
        Image smallLightHaze1 = new Image("Images/B2_4.PNG.png");
        uiView Haze1View = new uiView(smallLightHaze1, 1530, 300, 270, 270, true);  
            
        Image smallLightHaze2 = new Image("Images/B2_2.PNG.png");
        uiView Haze2View = new uiView(smallLightHaze2, 1530, 350, 270, 270, true);
        
        Image smallLightHaze4 = new Image("Images/B2_1.PNG.png");
        uiView Haze4View = new uiView(smallLightHaze4, 1380, 340, 250, 250, true);
        
        Image smallLightHaze5 = new Image("Images/S2_1.PNG.png");
        uiView Haze5View = new uiView(smallLightHaze5, 1380, 490, 200, 250, true);
        
        uiView[] buttonsList = {Haze1View, Haze2View, Haze4View, Haze5View};
        
        return buttonsList;
    }
    
    public uiView[] getHeavyButtons(){
        Image smallLightHaze1 = new Image("Images/B3_1.PNG.png");
        uiView Haze1View = new uiView(smallLightHaze1, 1530, 300, 270, 270, true);  
            
        Image smallLightHaze2 = new Image("Images/B3_3.PNG.png");
        uiView Haze2View = new uiView(smallLightHaze2, 1530, 350, 270, 270, true);
        
        Image smallLightHaze4 = new Image("Images/B3_4.PNG.png");
        uiView Haze4View = new uiView(smallLightHaze4, 1380, 340, 250, 250, true);
        
        Image smallLightHaze5 = new Image("Images/S3_1.PNG.png");
        uiView Haze5View = new uiView(smallLightHaze5, 1380, 490, 200, 250, true);
        
        uiView[] buttonsList = {Haze1View, Haze2View, Haze4View, Haze5View};
        
        return buttonsList;
    }
}
