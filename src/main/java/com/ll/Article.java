package com.ll;

import java.util.Map;

public class Article {
    int id;
    String title;
    String content;
    Article(int id, String title, String content){
        this.id = id;
        this.title = title;
        this.content = content;
    }
    Article(Map<String, Object> row){
        this.id = (int)row.get("id");
        this.title = (String)row.get("title");
        this.content = (String)row.get("content");
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

