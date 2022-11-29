package com.xunqingyao.scriptdemo.myScript.scriptMethodUtils.AST;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @Author qingyao
 * @Date 2022/11/12 21:15
 * @Version 1.0
 * @Coding utf-8
 */
@Component
public class MyAST {
    public ArrayList<Step> steps = new ArrayList<>();

    public MyAST() {
    }

    public MyAST(ArrayList<Step> steps) {
        this.steps = steps;
    }

    public ArrayList<Step> getSteps() {
        return steps;
    }
}
