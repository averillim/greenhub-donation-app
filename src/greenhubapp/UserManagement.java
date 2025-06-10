/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package greenhubapp;
/**
 *
 * @author abila
 */
public class UserManagement {
    //Creating a class to keep track of which user logs in
    private String LoginUser;
    private static UserManagement instance;
    
    public UserManagement() {
          LoginUser = "";
    }
       
    public String getUser(){
        return LoginUser;
    }
    
    public void setUser(String user){
        LoginUser = user;
    }
    
    public static UserManagement getInstance() {
        if (instance == null) {
            instance = new UserManagement();
        }
        return instance;
    }
     
    public void logOut(){
        setUser(null); 
        Login.getInstance().Login();
    }
}
