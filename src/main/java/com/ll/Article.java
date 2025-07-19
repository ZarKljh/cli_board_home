package com.ll;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class Article {
    int id;
    String title;
    String content;
    LocalDateTime regDate;
    Article(int id, String title, String content){
        this.id = id;
        this.title = title;
        this.content = content;
    }
    Article(Map<String, Object> row){
        this.id = (int)row.get("id");
        this.title = (String)row.get("subject");
        this.content = (String)row.get("content");
        this.regDate = (LocalDateTime)row.get("regDate");
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
    LocalDateTime getRegDate() {return this.regDate;}
    void setTitle(String title){
        this.title = title;
    }
    void setContent(String content){
        this.content = content;
    }
}

