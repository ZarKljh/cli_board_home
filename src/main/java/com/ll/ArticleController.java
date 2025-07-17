package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArticleController {
    Scanner sc;
    List<Article> articleList = new ArrayList<>();
    Article article;
    int lastid=0;

    ArticleController(Scanner sc){
        this.sc = sc;
    }

    public void write(){
        lastid++;
        System.out.print("Title: ");
        String inputTitle = sc.nextLine();
        System.out.print("Content: ");
        String inputContent = sc.nextLine();

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
    public void modify(String command){
        String[] commandList = command.split("\\?",2);
        String[] parms = commandList[1].split("=",2);
        int requestId = Integer.parseInt(parms[1]);

        article = _getFinebyId(requestId);

        if(article == null ) {
            System.out.println("Article is not founded!");
        } else {
            System.out.print("Title: ");
            String inputTitle = sc.nextLine();
            System.out.print("Content: ");
            String inputContent = sc.nextLine();
            article.setTitle(inputTitle);
            article.setContent(inputContent);
        }
    }

    public void remove(String command){
        String[] commandList = command.split("\\?",2);
        String[] parms = commandList[1].split("=",2);
        int requestId = Integer.parseInt(parms[1]);

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
}
