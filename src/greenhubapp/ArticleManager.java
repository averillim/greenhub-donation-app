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
import java.util.ArrayList;

public class ArticleManager {
    private ArrayList<Article> articles;
    
    //adding Article into articles array list
    public ArticleManager() {
    articles = new ArrayList<>();
    articles.add(new Article("Understanding Climate Change", "Impact of climate change on ecosystems.\nProvides a deep dive into its causes—human-driven \nactivities—and the resulting wide-ranging impacts,\nfrom extreme weather to ecosystem disruptions. ", "John Doe"));
    articles.add(new Article("Reducing Carbon Emissions", "Ways to decrease carbon footprint \nThe article underscores urgency in adopting \nthese solutions to mitigate the harmful impacts of \nexcessive carbon emissions on the environment and society..", "Jane Smith"));
    articles.add(new Article("The Effects of Global Warming", "Consequences of rising global temperatures. \nIt examines the far-reaching consequences of rising temperatures. \nIt details diverse impacts like extreme weather patterns, \nrising sea levels, habitat loss, etc.", "Alice Johnson"));
    articles.add(new Article("The Danger of Climate Change", "Negative impact when climate change happens.\nunderscores the imminent risks posed by this phenomenon. \nIt outlines grave threats such as extreme weather events, \nhabitat destruction, and economic instability.", "Emma Davis"));
    articles.add(new Article("The Impact of Carbon Emissions on Global Warming", "Discusses and elucidates the direct correlation \nbetween carbon output and escalating temperatures. \nIt explicates how excessive emissions intensify \nthe greenhouse effect, causing drastic climatic shifts.", "Michael Wilson"));
    }

    public ArrayList<Article> getArticles() {
        return articles;
    }
    public void addArticle(Article article) {
        articles.add(article);
        
    }

    public boolean deleteArticle(Article article) {
        boolean isDeleted = articles.remove(article);
        return isDeleted;
    }
    
    //Search feature
    public ArrayList<Article> searchArticles(String query) {
        ArrayList<Article> searchResults = new ArrayList<>();
        for (Article article : articles) {
            if (article.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                article.getContent().toLowerCase().contains(query.toLowerCase())) {
                searchResults.add(article);
            }
        }
        return searchResults;
    }
    
    public void editArticle(Article article, String Title, String Content, String Author){
        for(int i=0; i<articles.size(); i++){
            Article currentArticle = articles.get(i);
            if (currentArticle.getTitle().equals(article.getTitle())){
                currentArticle.setTitle(Title);
                currentArticle.setContent(Content);
                currentArticle.setAuthor(Author);
                break;
            }
        }
    }
}
