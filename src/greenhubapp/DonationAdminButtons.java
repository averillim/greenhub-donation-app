/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package greenhubapp;

import java.util.function.Consumer;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

/**
 *
 * @author Averil
 */
public class DonationAdminButtons extends HBox {
    
    //Creating buttons for edit and delete
    public DonationAdminButtons(Post post, Consumer<Post> onDelete, Consumer<Post> onEdit){
        Button deleteButton = new Button("Delete");
        Button editButton = new Button("Edit");

        deleteButton.setOnAction(e -> onDelete.accept(post));
        editButton.setOnAction(e -> onEdit.accept(post));
        
        getChildren().addAll(deleteButton, editButton);
        
        setAlignment(Pos.CENTER_RIGHT);
        setSpacing(10);   
    }
}
