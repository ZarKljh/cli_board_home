package com.ll.Member;

import com.ll.Container;
import java.util.Scanner;

public class MemberController {
    MemberService memberService;
    String memberUserId;

    public MemberController(){
        memberService = new MemberService();
    }

    public void login(){

        if(Session.isLoggedIn()){
            System.out.println("Already logIn!!");
            return;
        }
        System.out.print("ID : ");
        String userId = Container.getSc().nextLine();

        System.out.print("PASSWORD : ");
        String password = Container.getSc().nextLine();
        
        Member member = MemberService.list(userId,password).getFirst();
        this.memberUserId = member.getUserId();
        if (member != null) {
            Session.login(member);
            System.out.println(member.getUserId() + "  LogIN!");
        } else {
            System.out.println("Login Failed! Check your Id&PW Please!!");
        }
    }
    public void signin(){
        if(Session.isLoggedIn()){
            System.out.println("Before Signin, Logout first please!");
            return;
        }
        String userId = textCheck(Container.getSc(), "ID");
        String password = textCheck(Container.getSc(), "PASSWORD");

        if (MemberService.list(userId,password).isEmpty()) {
            MemberService.create(userId, password);
            System.out.println("Please Login by userId!");
        } else {
            System.out.println("Login Failed! Check your Id&PW Please!!");
        }

//        while(true){
//            System.out.print("ID : ");
//            userId = Container.getSc().nextLine();
//            if(userId.equals(Container.getSc().nextLine())){
//                break;
//            }
//        }
//        while(true){
//            System.out.print("PASSWORD : ");
//            password = Container.getSc().nextLine();
//            if(password.equals(Container.getSc().nextLine())){
//                break;
//            }
//        }
    }
    public String getMemberUserId(){
        return this.memberUserId;
    }
    public String textCheck(Scanner sc, String col){
        String value = "";
        boolean corract = true;
        while(corract){
            System.out.printf("%s : ", col);
            value = sc.nextLine();
            System.out.printf("Please Input %s one more please : ", col);
            if(value.equals(sc.nextLine())){
                corract = false;
                break;
            }
        }
        return value;
    }
}
