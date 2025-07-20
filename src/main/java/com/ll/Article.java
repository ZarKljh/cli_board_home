package com.ll;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class Article {
    int id;
    String title;
    String content;
    String userId;
    LocalDateTime regDate;

    Article(int id, String title, String content, String userId){
        this.id = id;
        this.title = title;
        this.content = content;
        this.userId = userId;
    }
    Article(Map<String, Object> row){
        this.id = (int)row.get("id");
        this.title = (String)row.get("title");
        this.content = (String)row.get("content");
        this.userId = (String)row.get("userId");
        this.regDate = (LocalDateTime)row.get("regDate");
    }
    int getId(){
        return this.id;
    }
    String getTitle(){
        return this.title;
    }
    String getContent(){return this.title; }
    String getUserId(){ return this.userId;}
    LocalDateTime getRegDate() {return this.regDate;}
    void setTitle(String title){
        this.title = title;
    }
    void setContent(String content){
        this.content = content;
    }
}

