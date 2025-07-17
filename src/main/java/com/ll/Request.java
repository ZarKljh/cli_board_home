package com.ll;

import java.util.HashMap;
import java.util.Map;

public class Request {

    private String actionCommand;
    private Map<String, String> params = new HashMap<>();

    public Request(String command){
        String[] commandList = command.split("\\?",2);
        actionCommand = commandList[0];

        if(commandList.length == 1) return;

        String[] parms = commandList[1].split("=", 2);

        String[] paramsList = commandList[1].split("&");

        for( String paramsRow : paramsList){
            String[] param = paramsRow.split("=",2);
            String key = param[0];
            String value = param[1];
            params.put(key,value);
        }

    }

    public String getActionCommand(){
        return actionCommand;
    }
    public String getParams(String key){
        return params.get(key);
    }
}
