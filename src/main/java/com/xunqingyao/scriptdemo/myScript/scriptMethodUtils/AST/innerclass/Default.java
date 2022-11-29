package com.xunqingyao.scriptdemo.myScript.scriptMethodUtils.AST.innerclass;

/**
 * @Author qingyao
 * @Date 2022/11/13 12:15
 * @Version 1.0
 * @Coding utf-8
 */
public class Default {
    String nextStepID = null;

    @Override
    public String toString() {
        return "Default{" +
                "nextStepID='" + nextStepID + '\'' +
                '}';
    }

    public String getNextStepID() {
        return nextStepID;
    }

    public void setNextStepID(String nextStepID) {
        this.nextStepID = nextStepID;
    }

    public Default() {
    }

    public Default(String nextStepID) {
        this.nextStepID = nextStepID;
    }
}
