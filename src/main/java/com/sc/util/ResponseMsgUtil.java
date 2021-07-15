package com.sc.util;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;

public class ResponseMsgUtil {
    private LinkedHashMap<String,Object> messages;
    private static ResponseMsgUtil responseMsg = new ResponseMsgUtil();

    private ResponseMsgUtil getResponseMsg(){
        return responseMsg;
    }

    private void initMsg(){
        this.messages = new LinkedHashMap<String,Object>();
    }

    private void setMessage(String k,Object v){
        responseMsg.messages.put(k, v);
    }

    private String toJson(){
        return JsonUtil.toJson(responseMsg.messages);
    }

    public static String getResponseMsg(String k,String v){
        responseMsg.initMsg();
        responseMsg.setMessage(k, v);
        return responseMsg.toJson();
    }

    public static String getResult(String r){
        responseMsg.initMsg();
        responseMsg.setMessage("result",r);
        return responseMsg.toJson();
    }

    public static String getResult(){
        return getResult("success");
    }

    public static String getResult(boolean f){
        if (!f) return getResult("fail");
        else return getResult();
    }

    public static String getResponseMsg(LinkedHashMap<String,Object> map){
        responseMsg.messages = map;
        return responseMsg.toJson();
    }

    public static String getResponseMsg(Object...args){
        responseMsg.initMsg();
        if ((args.length%2) == 0){
            for (int i = args.length-1; i >= 0; i-=2) {
                responseMsg.setMessage((String) args[i-1],args[i]);
            }
        }else {
            for (int i = args.length-2; i >= 0; i-=2) {
                responseMsg.setMessage((String)args[i-1],args[i]);
            }
        }
        return responseMsg.toJson();
    }

    public static String getResult(int i){
        if (i == 0) return getResult(false);
        return getResult();
    }

    public static void setParam(String id, String value, HttpServletResponse response){
        String input = "<input type='hidden' id='"+id+"' value='"+value+"'>";
        response.setCharacterEncoding("UTF-8");
        try {
            response.getWriter().write(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
