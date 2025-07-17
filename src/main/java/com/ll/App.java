package com.ll;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    Scanner sc;
    App(Scanner sc){
        this.sc = sc;
    }
    public void run(){

        Article article;
        List<Article> articleList = new ArrayList<>();
        int lastid=0;

        System.out.println("==== CLI Board App start ====");
        while(true){
            System.out.print("Command : ");
            String command = sc.nextLine().trim();

            if(command.equals("exit")){
                System.out.println("CLI Board close");
                break;
            } else if (command.equals("write")){
                lastid++;
                System.out.print("Title: ");
                String inputTitle = sc.nextLine();
                System.out.print("Content: ");
                String inputContent = sc.nextLine();

                article = new Article(lastid, inputTitle, inputContent);
                articleList.add(article);
                System.out.printf("No %d / %s / %s is saved!\n", article.getId(),article.getTitle(),article.getContent());
            } else if(command.equals("list")){
                int size = articleList.size();
                for(int i = size-1; i>=0 ; i--){
                    article = articleList.get(i);
                    System.out.printf("No %d / %s / %s\n", article.getId(),article.getTitle(),article.getContent());
                }
            } else if(command.startsWith("modify")){
                String[] commandList = command.split("\\?",2);
                String[] parms = commandList[1].split("=",2);
                int requestId = Integer.parseInt(parms[1]);

                article = null;
                for( Article item : articleList) {
                    if(item.getId() == requestId){
                        article = item;
                    }
                }
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
            }else if(command.startsWith("remove")){
                String[] commandList = command.split("\\?",2);
                String[] parms = commandList[1].split("=",2);
                int requestId = Integer.parseInt(parms[1]);

                article = null;
                for(Article item : articleList){
                    if(item.getId() == requestId){
                        article = item;
                    }
                }
                if (article == null){
                    System.out.println("Article is not founded!");
                }else{
                    articleList.remove(article);
                    System.out.printf("No%d Article is removed!!\n",requestId);
                }

            }
        }

    }

}

