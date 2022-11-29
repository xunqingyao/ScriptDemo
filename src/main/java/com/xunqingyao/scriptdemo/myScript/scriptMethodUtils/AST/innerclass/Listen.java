package com.xunqingyao.scriptdemo.myScript.scriptMethodUtils.AST.innerclass;

/**
 * @Author qingyao
 * @Date 2022/11/12 22:55
 * @Version 1.0
 * @Coding utf-8
 */
public class Listen {
    int startTime = 0;
    int endTime = 0;

    @Override
    public String toString() {
        return "Listen{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public Listen(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Listen() {
    }
}
