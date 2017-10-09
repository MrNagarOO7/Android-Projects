package com.example.mrnagar.listview;

/**
 * Created by Mr.Nagar on 16-09-2017.
 */
public class Books {
    public String title;
    public String author;

    public Books(String title,String author)
    {
        this.author=author;
        this.title=title;
    }

    public void setTitle(String title){
        this.title=title;
    }

    public void setAuthor(String author){
        this.author=author;
    }
    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }
}
