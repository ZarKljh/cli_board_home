package com.ll;
import com.ll.Member.MemberController;
import com.ll.Member.Session;
import com.ll.db.DBConnection;

public class App {

    ArticleController articleController;
    MemberController memberController;

    App(){
        DBConnection.DB_NAME = "proj1";
        DBConnection.DB_PORT = 3306;
        DBConnection.DB_USER = "root";
        DBConnection.DB_PASSWORD = "";

        Container.getDBConnection().connect();

        articleController = new ArticleController();
        memberController = new MemberController();

    }
    public void run(){

        System.out.println("==== CLI Board App start ====");

        while (!Session.isLoggedIn()) {
            System.out.println("[로그인이 필요합니다]");
            memberController.login();

            if (!Session.isLoggedIn()) {
                System.out.println("로그인 실패. 다시 시도해주세요.\n");
            }
        }


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


