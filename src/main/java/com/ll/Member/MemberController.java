package com.ll.Member;

import com.ll.Container;
import java.util.Scanner;

public class MemberController {
    MemberService memberService;

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
        
        Member member = MemberService.list(userId,password).get(0);

        if (member != null) {
            Session.login(member);
            System.out.println(member.userId + "  LogIN!");
        } else {
            System.out.println("Login Failed! Check your Id&PW Please!!");
        }
    }
}
