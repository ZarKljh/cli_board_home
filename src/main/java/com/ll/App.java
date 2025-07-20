package com.ll;
import com.ll.Member.MemberController;
import com.ll.Member.Session;
import com.ll.db.DBConnection;

public class App {

    ArticleController articleController;
    MemberController memberController;
    String memberUserId;
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


        // !Session.isLoggedIn() --> 로그아웃상태라면?? 이라는 뜻
        while (true) {
            System.out.println("============ Choice MENU ==========");
            System.out.println("======== login signin exit ========");
            System.out.print("Command : ");
            String command = Container.getSc().nextLine().trim();
            Request request = new Request(command);

            if(request.getActionCommand().equals("login")){
                System.out.println("Login Please!");
                memberController.login();
                memberUserId = memberController.getMemberUserId();
                break;
            } else if (request.getActionCommand().equals("signin")){
                //memberContrtoller.signin();
                //memberContrtoller.login();
            } else if (request.getActionCommand().equals("exit")) {
                System.out.println("CLI Board close");
                break;
            }
        }

        while(Session.isLoggedIn()){
            System.out.println("============ Choice MENU ==========");
            System.out.println("======== list write modify ========");
            System.out.println("============ remove exit ==========");

            System.out.print("Command : ");
            String command = Container.getSc().nextLine().trim();
            Request request = new Request(command);

            if(request.getActionCommand().equals("exit")){
                System.out.println("CLI Board close");
                break;
            } else if (request.getActionCommand().equals("write")){
                articleController.write(memberUserId);
            } else if(request.getActionCommand().equals("list")){
                articleController.list();
            } else if(request.getActionCommand().startsWith("modify")){
                articleController.modify(request,memberUserId);
            }else if(request.getActionCommand().startsWith("remove")){
                articleController.remove(request,memberUserId);
            }
        }

    }
}


