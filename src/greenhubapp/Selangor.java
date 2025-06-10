package greenhubapp;

import javafx.scene.image.Image;

public class Selangor extends States implements Region{
    
    public Selangor(String stateName, int carbonEmission, int levelAPI, int hazePercent) {
        super(stateName, carbonEmission, levelAPI, hazePercent);
    }
    
    public uiView[] getNoButtons(){
        uiView[] buttonsList = {};
        
        return buttonsList;
    }
    
    public uiView[] getLightButtons(){
        Image smallLightHaze1 = new Image("Images/S1_5.PNG.png");
        uiView Haze1View = new uiView(smallLightHaze1, 230, 390, 100, 100, true);  
        
        Image smallLightHaze2 = new Image("Images/S1_4.PNG.png");
        uiView Haze2View = new uiView(smallLightHaze2, 180, 370, 100, 100, true);
        
        Image smallLightHaze3 = new Image("Images/S1_3.PNG.png");
        uiView Haze3View = new uiView(smallLightHaze3, 200, 370, 100, 100, true);
        
        Image smallLightHaze4 = new Image("Images/S1_2.PNG.png");
        uiView Haze4View = new uiView(smallLightHaze4, 230, 450, 100, 100, true);
        
        uiView[] buttonsList = {Haze1View, Haze2View, Haze3View, Haze4View};
        
        return buttonsList;
    }
    
    public uiView[] getMediumButtons(){
        Image smallLightHaze1 = new Image("Images/S2_5.PNG.png");
        uiView Haze1View = new uiView(smallLightHaze1, 230, 390, 100, 100, true);  
            
        Image smallLightHaze2 = new Image("Images/S2_4.PNG.png");
        uiView Haze2View = new uiView(smallLightHaze2, 180, 370, 100, 100, true);
        
        Image smallLightHaze3 = new Image("Images/S2_3.PNG.png");
        uiView Haze3View = new uiView(smallLightHaze3, 200, 370, 100, 100, true);
        
        Image smallLightHaze4 = new Image("Images/S2_2.PNG.png");
        uiView Haze4View = new uiView(smallLightHaze4, 230, 430, 100, 100, true);
        
        uiView[] buttonsList = {Haze1View, Haze2View, Haze3View, Haze4View};
        
        return buttonsList;
    }
    
    public uiView[] getHeavyButtons(){
        Image smallLightHaze1 = new Image("Images/S3_5.PNG.png");
        uiView Haze1View = new uiView(smallLightHaze1, 230, 390, 100, 100, true);  
            
        Image smallLightHaze2 = new Image("Images/S3_4.PNG.png");
        uiView Haze2View = new uiView(smallLightHaze2, 180, 370, 100, 100, true);
        
        Image smallLightHaze3 = new Image("Images/S3_3.PNG.png");
        uiView Haze3View = new uiView(smallLightHaze3, 200, 370, 100, 100, true);
        
        Image smallLightHaze4 = new Image("Images/S3_2.PNG.png");
        uiView Haze4View = new uiView(smallLightHaze4, 230, 430, 100, 100, true);
        
        uiView[] buttonsList = {Haze1View, Haze2View, Haze3View, Haze4View};
        
        return buttonsList;
    }
}
