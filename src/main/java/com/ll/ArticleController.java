package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArticleController {

    List<Article> articleList = new ArrayList<>();
    Article article;
    int lastid = 0;

    public void write(){
        lastid++;
        System.out.print("Title: ");
        String inputTitle = Container.getSc().nextLine();
        System.out.print("Content: ");
        String inputContent = Container.getSc().nextLine();

        article = new Article(lastid, inputTitle, inputContent);
        articleList.add(article);
        System.out.printf("No %d / %s / %s is saved!\n", article.getId(),article.getTitle(),article.getContent());
    }

    public void list(){
        int size = articleList.size();
        for(int i = size-1; i>=0 ; i--){
            article = articleList.get(i);
            System.out.printf("No %d / %s / %s\n", article.getId(),article.getTitle(),article.getContent());
        }
    }
    public void modify(Request request){

        int requestId = _getintParam(request);

        article = _getFinebyId(requestId);

        if(article == null ) {
            System.out.println("Article is not founded!");
        } else {
            System.out.print("Title: ");
            String inputTitle = Container.getSc().nextLine();
            System.out.print("Content: ");
            String inputContent = Container.getSc().nextLine();
            article.setTitle(inputTitle);
            article.setContent(inputContent);
        }
    }

    public void remove(Request request){

        int requestId = _getintParam(request);
        article = _getFinebyId(requestId);

        if (article == null){
            System.out.println("Article is not founded!");
        }else{
            articleList.remove(article);
            System.out.printf("No%d Article is removed!!\n",requestId);
        }
    }
    private Article _getFinebyId(int requestId){
        for( Article item : articleList) {
            if(item.getId() == requestId){
                return item;
            }
        }
        return null;
    }
    private int _getintParam(Request request){
        int defualtValue = -1;

        try {
            return Integer.parseInt(request.getParams("id"));
        } catch(NumberFormatException e) {
            return defualtValue;
        }

    }
}
