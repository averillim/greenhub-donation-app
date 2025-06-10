/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package greenhubapp;

import java.util.ArrayList;
import javafx.scene.image.Image;

/**
 *
 * @author abila
 */
public class AllPosts {
    //Creating an array list to store posts
    private final ArrayList<Post> allPosts = new ArrayList<>();   
    private static AllPosts instance;

    //Getting the instance of AllPosts
    public static AllPosts getInstance() {
        if (instance == null) {
            instance = new AllPosts();
        }
        return instance;
    }
    //Preloading data for posts 
    public AllPosts(){
        Image wwf = new Image("Images/wwf.jpg");
        Post wwfPost = new Post("WWF Malaysia", """
                                Everyone needs healthy forests, rivers and seas to survive.
                                By protecting our wildlife, natural ecosystems and
                                resources, WWF-Malaysia is helping to protect our
                                livelihoods, fresh water, food security and clean air.""", wwf, 1000.00);
        
        Image planetUs = new Image("Images/planet_us.png");
        Post planetUsPost = new Post("Planet Us", """
                                Educating and inspiring Malaysian youths to play a more
                                proactive role in tackling the climate crisis as well as
                                contributing to an environmentally sustainable future.""", planetUs, 500.00);
        
        Image netZero = new Image("Images/net_zero.jpg");
        Post netZeroPost = new Post("Net Zero 2050", """
                                A climate-neutral society is achievable if we change how
                                we produce and consume. Lead the way towards Net-Zero and
                                build the future.""", netZero, 10000.00);
        
        
        allPosts.add(wwfPost);
        allPosts.add(planetUsPost);
        allPosts.add(netZeroPost);
    }
    //Getting the arraylist for posts
    public ArrayList<Post> getAllPosts() {
        return allPosts;
    }
    //Method for adding a post
    public void addPost(Post newPost) {
        allPosts.add(newPost);
    }
}
