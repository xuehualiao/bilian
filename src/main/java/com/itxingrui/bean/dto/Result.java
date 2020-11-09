package com.itxingrui.bean.dto;

import java.util.HashMap;

public class Result {

    private int state;

    private String msg;

    private HashMap<String,Object> data;


    public static Result getSuccess(){
        Result result = new Result();
        result.setState(200);
        return result;
    }

    public static Result getFaild(){
        Result result = new Result();
        result.setState(500);
        return result;
    }

    public int getState() {
        return state;
    }

    private void setState(int state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public HashMap<String, Object> getData() {
        return data;
    }

    public void setData(HashMap<String, Object> data) {
        this.data = data;
    }
}
