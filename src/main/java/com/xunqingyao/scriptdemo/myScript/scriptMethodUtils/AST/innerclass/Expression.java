package com.xunqingyao.scriptdemo.myScript.scriptMethodUtils.AST.innerclass;

/**
 * @Author qingyao
 * @Date 2022/11/12 23:18
 * @Version 1.0
 * @Coding utf-8
 */
public class Expression {
    String speakContent = null;

    public Expression() {
    }

    public String getSpeakContent() {
        return speakContent;
    }

    public void setSpeakContent(String speakContent) {
        this.speakContent = speakContent;
    }

    public Expression(String speakContent) {
        this.speakContent = speakContent;
    }

    @Override
    public String toString() {
        return "Expression{" +
                "speakContent='" + speakContent + '\'' +
                '}';
    }
}
