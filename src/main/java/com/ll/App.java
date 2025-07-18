package com.ll;
import com.ll.db.DBConnection;

public class App {

    ArticleController articleController;

    App(){
        DBConnection.DB_NAME = "proj1";
        DBConnection.DB_PORT = 3306;
        DBConnection.DB_USER = "root";
        DBConnection.DB_PASSWORD = "";



       // DBConnection DBConnection = new DBConnection();
        Container.getDBConnection().connect();
        //DBConnection.connect();

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


