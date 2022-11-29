package com.xunqingyao.scriptdemo.myScript.scriptMethodUtils.AST.innerclass;

/**
 * @Author qingyao
 * @Date 2022/11/13 12:14
 * @Version 1.0
 * @Coding utf-8
 */
public class Silence {
    String nextStepID = null;

    @Override
    public String toString() {
        return "Silence{" +
                "nextStepID='" + nextStepID + '\'' +
                '}';
    }

    public String getNextStepID() {
        return nextStepID;
    }

    public void setNextStepID(String nextStepID) {
        this.nextStepID = nextStepID;
    }

    public Silence() {
    }

    public Silence(String nextStepID) {
        this.nextStepID = nextStepID;
    }
}
