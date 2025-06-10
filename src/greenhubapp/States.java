package greenhubapp;

public class States {
    //Creating States object
    private String stateName;
    private int carbonEmission;
    private int hazePercent;
    private int levelAPI;
        
    public States(String stateName, int carbonEmission, int levelAPI, int hazePercent){
        this.stateName = stateName;
        this.carbonEmission = carbonEmission;
        this.levelAPI = levelAPI;
        this.hazePercent = hazePercent;
    }
    
    public String getName(){
        return stateName;
    }
    
    public int getCarbonEmission(){
        return carbonEmission;
    }
    
    public int getHazePercent(){
        return hazePercent;
    }
    
    public int getlevelAPI(){
        return this.levelAPI;
    }
    
    public void setEmission (int emission){
        this.carbonEmission = emission;
    }
    
    public void setAPI (int API){
        this.levelAPI = API;
    }
    
    public void setHaze (int Percent){
        this.hazePercent = Percent;
    }
    
    public int getHazeLevel(){
        if (this.levelAPI < 50){
            return 1;
        } else if (this.levelAPI >= 50 && this.levelAPI < 100){
            return 2;
        } else if (this.levelAPI >= 100 && this.levelAPI < 200){
            return 3;
        } else if (this.levelAPI >= 200){
            return 4;
        }
        return 5;
    }
}
