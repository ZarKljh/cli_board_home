package com.ll;

public class Article {
    int id;
    String title;
    String content;
    Article(int id, String title, String content){
        this.id = id;
        this.title = title;
        this.content = content;
    }
    int getId(){
        return this.id;
    }
    String getTitle(){
        return this.title;
    }
    String getContent(){
        return this.title;
    }
    void setTitle(String title){
        this.title = title;
    }
    void setContent(String content){
        this.content = content;
    }
}

