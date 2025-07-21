package com.ll.Member;

import com.ll.Container;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MemberRepository {

    public List<Member> findAll(String userId, String password){
        List<Member> memberList = new ArrayList<>();
        String sql = String.format("select * from members where userId='%s' and password='%s'",userId,password);
        List<Map<String, Object>> rows = Container.getDBConnection().selectRows(sql);

        for(Map<String, Object> row : rows){
            Member member = new Member(row);
            memberList.add(member);
        }
        return memberList;
    }
    public void create(String userId, String password){
        String sql = String.format("Insert into members set userId='%s', password='%s', regDate=now()",userId,password);
        Container.getDBConnection().insert(sql);
    }
}