package com.ll.Member;

import java.util.List;

public class MemberService {

    static MemberRepository memberRespostiry;

    MemberService(){
        memberRespostiry = new MemberRepository();
    }

    static List<Member> list(String userId, String password){
        return memberRespostiry.findAll(userId, password);
    }
    static void create (String userId, String password){
        memberRespostiry.create(userId, password);
    }
}

