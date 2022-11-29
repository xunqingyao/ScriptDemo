package com.xunqingyao.scriptdemo.myScript.scriptMethodUtils.beans;

/**
 * @Author qingyao
 * @Date 2022/11/12 20:11
 * @Version 1.0
 * @Coding utf-8
 */
public class StateCode {
    int code;
    String msg;

    @Override
    public String toString() {
        return "stateCode{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public StateCode() {
    }

    public StateCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
