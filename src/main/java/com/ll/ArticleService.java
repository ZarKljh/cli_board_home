package com.ll;

import java.util.ArrayList;
import java.util.List;

public class ArticleService {
    ArticleRepository articleRepository;

    int lastid = 0;

    //List<Article> articleList = new ArrayList<>();

    ArticleService(){
        articleRepository = new ArticleRepository();
    }

    public Article create(String inputTitle, String inputContent){
        lastid++;
        //Article article = new Article();
        Article article = articleRepository.create(lastid, inputTitle,inputContent);
        return article;
    }
    public List<Article> getArticleList(){
       return articleRepository.findAll();
    }
    public void modify(Article article,String inputTitle, String inputContent){
        articleRepository.modify(article,inputTitle,inputContent);
    }
    public void remove(Article article){
        articleRepository.remove(article);
    }
    public Article _getFinebyId(int requestId){
        for( Article item : articleRepository.findAll()) {
            if(item.getId() == requestId){
                return item;
            }
        }
        return null;
    }
}
