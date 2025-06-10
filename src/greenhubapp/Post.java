/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package greenhubapp;

import javafx.scene.image.Image;

public class Post {
    //Creating Post object
    private String title;
    private String description;
    private Image image;
    private double donationGoal;
    
    public Post(String title, String description, Image image, Double donationGoal) {
        this.title = title;
        this.description = description;
        this.donationGoal = donationGoal;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public Image getImage() {
        return image;
    }
    
    public void setImage(Image image) {
        this.image = image;
    }
    
    public double getGoal() {
        return donationGoal;
    }
    
    public void setGoal(double goal) {
        this.donationGoal = goal;
    }
   
}
