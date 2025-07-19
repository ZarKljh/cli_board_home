package com.ll;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ArticleController {

    ArticleService articleService;

    Article article;

    ArticleController(){
        articleService = new ArticleService();
    }


    public void write(){
        //lastid++;
        System.out.print("Title: ");
        String inputTitle = Container.getSc().nextLine();
        System.out.print("Content: ");
        String inputContent = Container.getSc().nextLine();

        int id = articleService.create(inputTitle, inputContent);



        System.out.printf("No %d Article is saved!!\n", id);
    }

    public void list(){
        List<Article> articleList = articleService.getArticleList();
        int size = articleList.size();
        for(int i = size-1; i>=0 ; i--){
            article = articleList.get(i);
            String formattedNow = dateFormat(article.getRegDate());
            System.out.printf("No %d / %s / %s / %s\n", article.getId(),article.getTitle(),article.getContent(),article, formattedNow);
        }
    }
    public void modify(Request request){

        int requestId = _getintParam(request);

        article = articleService._getFinebyId(requestId);

        if(article == null ) {
            System.out.println("Article is not founded!");
        } else {
            System.out.print("Title: ");
            String inputTitle = Container.getSc().nextLine();
            System.out.print("Content: ");
            String inputContent = Container.getSc().nextLine();
            articleService.modify(article,inputTitle,inputContent);
        }
    }

    public void remove(Request request){

        int requestId = _getintParam(request);
        article = articleService._getFinebyId(requestId);

        if (article == null){
            System.out.println("Article is not founded!");
        }else{
            articleService.remove(article);
            System.out.printf("No%d Article is removed!!\n",requestId);
        }
    }

    private int _getintParam(Request request){
        int defualtValue = -1;

        try {
            return Integer.parseInt(request.getParams("id"));
        } catch(NumberFormatException e) {
            return defualtValue;
        }
    }
    private String dateFormat(LocalDateTime regDate){
        //SimpleDateFormat formatRegDate = new SimpleDateFormat("yyyy.MM.dd-HH.mm.ss");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedNow = regDate.format(formatter);

        return formattedNow;
    }
}
