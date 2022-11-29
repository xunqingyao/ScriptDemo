package com.xunqingyao.scriptdemo.myScript.scriptMethodUtils.AST;


import com.xunqingyao.scriptdemo.myScript.scriptMethodUtils.AST.innerclass.*;
import com.xunqingyao.scriptdemo.myScript.scriptMethodUtils.AST.sqlUtils.Delete;
import com.xunqingyao.scriptdemo.myScript.scriptMethodUtils.AST.sqlUtils.Insert;
import com.xunqingyao.scriptdemo.myScript.scriptMethodUtils.AST.sqlUtils.Select;
import com.xunqingyao.scriptdemo.myScript.scriptMethodUtils.AST.sqlUtils.Update;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author qingyao
 * @Date 2022/11/12 20:51
 * @Version 1.0
 * @Coding utf-8
 */
@ToString
@Component
public class Step {
    String stepId = null;
    Expression expression = new Expression();
    Listen listen = new Listen();
    InputContent inputContent = new InputContent();
    HashMap<String, String> branches = new HashMap<>();
    Silence silence = new Silence();
    Default aDefault = new Default();
    Select select = new Select();
    Insert insert = new Insert();
    Delete delete = new Delete();
    Update update = new Update();

    public InputContent getInputContent() {
        return inputContent;
    }

    public void setInputContent(InputContent inputContent) {
        this.inputContent = inputContent;
    }
    public Silence getSilence() {
        return silence;
    }

    public void setSilence(String nextStepID) {
        this.silence.setNextStepID(nextStepID);
    }

    public void setSelect(Select select) {
        this.select = select;
    }
    public void setInsert(Insert insert) {
        this.insert = insert;
    }

    public void setDelete(Delete delete) {
        this.delete = delete;
    }

    public void setUpdate(Update update) {
        this.update = update;
    }

    public Select getSelect() {
        return select;
    }

    public Insert getInsert() {
        return insert;
    }

    public Delete getDelete() {
        return delete;
    }

    public Update getUpdate() {
        return update;
    }

    public Default getaDefault() {
        return aDefault;
    }

    public void setaDefault(String nextStepID) {
        this.aDefault.setNextStepID(nextStepID);
    }

    public Step(String stepId, Expression expression, Listen listen, HashMap<String, String> branches, Silence silence,  Default aDefault) {
        this.stepId = stepId;
        this.expression = expression;
        this.listen = listen;
        this.branches = branches;
        this.silence = silence;
        this.aDefault = aDefault;
    }

    public String getStepId() {
        return stepId;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public Listen getListen() {
        return listen;
    }

    public void setListen(Listen listen) {
        this.listen = listen;
    }

    public HashMap<String, String> getBranches() {
        return branches;
    }

    public void setBranches(String answer, String stepId) {
        branches.put(answer.substring(1,answer.length() - 1), stepId);
    }

    public void setStepId(String stepId) {
        this.stepId = stepId;
    }


    public Step() {
    }

    public Step(String stepId) {
        this.stepId = stepId;
    }
}
