package com.ll;

import java.util.ArrayList;
import java.util.List;

public class ArticleService {
    ArticleRepository articleRepository;

    ArticleService(){
        articleRepository = new ArticleRepository();
    }

    public int create(String inputTitle, String inputContent, String memberUserId){

        int id  = articleRepository.create(inputTitle,inputContent, memberUserId);
        return id;
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
