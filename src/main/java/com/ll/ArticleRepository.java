package com.ll;

import java.util.ArrayList;
import java.util.List;

public class ArticleRepository {
    List<Article> articleList = new ArrayList<>();


    public Article create(int lastid, String inputTitle, String inputContent){
        Article article = new Article(lastid,inputTitle,inputContent);
        articleList.add(article);
        return article;
    }
    public List<Article> findAll(){
        return articleList;
    }
    public void modify(Article article, String inputTitle, String inputContent){
        article.setTitle(inputTitle);
        article.setContent(inputContent);
    }
    public void remove(Article article){
        articleList.remove(article);
    }
}
