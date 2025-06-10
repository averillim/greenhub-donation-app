package greenhubapp;

interface Region {
    public uiView[] getNoButtons();
    public uiView[] getLightButtons();
    public uiView[] getMediumButtons();
    public uiView[] getHeavyButtons();
    public int getCarbonEmission();
    public int getlevelAPI();
    public String getName();
    public void setEmission (int emission);
    public void setAPI (int API);
    public void setHaze (int Percent);


}
