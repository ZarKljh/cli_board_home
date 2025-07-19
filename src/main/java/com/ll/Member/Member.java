package com.ll.Member;

import java.time.LocalDateTime;
import java.util.Map;

public class Member {
    int id;
    String userId;
    String password;
    LocalDateTime regDate;

    Member(Map<String, Object> row){
        this.id = (int)row.get("id");
        this.userId = (String)row.get("userId");
        this.password = (String)row.get("password");
        this.regDate = (LocalDateTime)row.get("regDate");
    }


}
