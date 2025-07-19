package com.ll.Member;

public class Session {
    private static Member loggedInMember = null;

    public static boolean isLoggedIn() {
        return loggedInMember != null;
    }
    public static void login(Member member) {
        loggedInMember = member;
    }
    public static void logout() {
        loggedInMember = null;
    }
    public static Member getLoggedInMember() {
        return loggedInMember;
    }
}

