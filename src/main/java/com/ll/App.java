package com.ll;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    Scanner sc;
    ArticleController articleController;
    App(Scanner sc){
        this.sc = sc;
        articleController = new ArticleController(sc);
    }
    public void run(){



        System.out.println("==== CLI Board App start ====");
        while(true){
            System.out.print("Command : ");
            String command = sc.nextLine().trim();

            if(command.equals("exit")){
                System.out.println("CLI Board close");
                break;
            } else if (command.equals("write")){
                articleController.write();
            } else if(command.equals("list")){
                articleController.list();
            } else if(command.startsWith("modify")){
                articleController.modify(command);
            }else if(command.startsWith("remove")){
                articleController.remove(command);
            }
        }

    }
}


