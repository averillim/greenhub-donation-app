/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package greenhubapp;
;

/**
 *
 * @author bianca
 */


public class Article {
    //Fields for title, content and author
    private String title;
    private String content;
    private String author;
    

    public Article(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
    
    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setContent(String content){
        this.content = content;
    }
    
    public void setAuthor(String author){
        this.author = author;
    }

}
