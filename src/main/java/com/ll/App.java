package com.ll;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    ArticleController articleController;

    App(){
        articleController = new ArticleController();
    }
    public void run(){

        System.out.println("==== CLI Board App start ====");
        while(true){
            System.out.print("Command : ");
            String command = Container.getSc().nextLine().trim();
            Request request = new Request(command);

            if(request.getActionCommand().equals("exit")){
                System.out.println("CLI Board close");
                break;
            } else if (request.getActionCommand().equals("write")){
                articleController.write();
            } else if(request.getActionCommand().equals("list")){
                articleController.list();
            } else if(request.getActionCommand().startsWith("modify")){
                articleController.modify(request);
            }else if(request.getActionCommand().startsWith("remove")){
                articleController.remove(request);
            }
        }

    }
}


