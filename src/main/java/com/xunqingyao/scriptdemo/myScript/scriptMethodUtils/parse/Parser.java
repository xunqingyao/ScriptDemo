package com.xunqingyao.scriptdemo.myScript.scriptMethodUtils.parse;

import com.xunqingyao.scriptdemo.myScript.scriptMethodUtils.AST.MyAST;
import com.xunqingyao.scriptdemo.myScript.scriptMethodUtils.AST.Script;
import com.xunqingyao.scriptdemo.myScript.scriptMethodUtils.AST.Step;
import com.xunqingyao.scriptdemo.myScript.scriptMethodUtils.AST.innerclass.Expression;
import com.xunqingyao.scriptdemo.myScript.scriptMethodUtils.AST.innerclass.InputContent;
import com.xunqingyao.scriptdemo.myScript.scriptMethodUtils.AST.innerclass.Listen;
import com.xunqingyao.scriptdemo.myScript.scriptMethodUtils.beans.StateCode;
import com.xunqingyao.scriptdemo.myScript.scriptMethodUtils.errors.FileContentError;
import com.xunqingyao.scriptdemo.myScript.scriptMethodUtils.errors.MyIOError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author qingyao
 * @Date 2022/11/23 18:40
 * @Version 1.0
 * @Coding utf-8
 */
@Slf4j
@Component
public class Parser {

    private Step step = null;

    @Autowired
    MyAST myAST;

    @Autowired
    Script script;

    @Autowired
    HashMap<Object, Object> info;

    /**
     * 解析脚本文件
     * @param url 脚本文件路径
     * @return 文件解析状态 code为1时文件正常解析，code为0时文件解析异常
     */
    public StateCode ParseFile(String url){
        StateCode sc = new StateCode();
        BufferedReader br = null;
        int lineCnt = 1;
        try{
            br = new BufferedReader(new FileReader(ResourceUtils.getFile(url)));
            String line = null;
            while((line = br.readLine()) != null) {
                if (line.length() == 0 || line.charAt(0) == '#') {
                    lineCnt++;
                    continue;
                }
                ParseLine(line.trim(),lineCnt);
                lineCnt++;
            }
        }catch(FileNotFoundException e) {
            new MyIOError(1);
            sc.setCode(0);
        }catch (IOException e) {
            new MyIOError(2);
            sc.setCode(0);
        }finally{
            try {
                br.close();
                sc.setCode(1);
            } catch (IOException e) {
                new MyIOError(3);
                sc.setCode(0);
            }
        }
        info.put("script",script);
        return sc;
    }

    /**
     * 解析行
     * @param line 行内容
     * @param lineCnt 行数
     */
    public void ParseLine(String line,int lineCnt){
        String[] tokens = line.split(" ");
        switch(tokens[0]){
            case "Step": ProcessStep(tokens[1]);break;
            case "Speak": ProcessSpeak(Arrays.copyOfRange(tokens, 1, tokens.length));break;
            case "Listen": ProcessListen(tokens[1], tokens[2]);break;
            case "Silence": ProcessSilence(tokens[1]);break;
            case "Branch": ProcessBranch(tokens[1], tokens[2]);break;
            case "Input": ProcessInput(tokens[1]);break;
            case "Query": ProcessQuery(tokens[1], lineCnt);break;
            case "Exit": ProcessExit();break;
            case "Default": ProcessDefault(tokens[1]);break;
            default: new FileContentError(lineCnt,tokens[0]);break;
        }
    }

    /**
     * 解析input
     * @param token input后的内容
     */
    private void ProcessInput(String token) {
        InputContent inputContent = new InputContent();
        inputContent.getName().add(token);
        step.setInputContent(inputContent);
    }

    /**
     * 解析step
     * @param process
     */
    private void ProcessStep(String process) {
        if(step != null){
            myAST.getSteps().add(step);
        }
        step = new Step(process);
        script.setSteps(process,step);
        if(myAST.getSteps().isEmpty()){
            script.setEntry(process);
        }
    }

    /**
     * 解析Speak
     * @param text
     */
    private void ProcessSpeak(String[] text) {
        step.setExpression(ProcessExpression(text));
    }

    /**
     * 新建Expression注入到Step中
     * @param text
     * @return
     */
    private Expression ProcessExpression(String[] text){
        StringBuilder sb = new StringBuilder();
        for(String s : text){
            sb.append(s + " ");
        }
        Expression expression = new Expression(sb.toString());
        return expression;


    }

    /**
     * 新建Listen注入到Step中
     * @param startTime
     * @param endTime
     */
    private void ProcessListen(String startTime, String endTime) {
        Listen listen = new Listen(Integer.valueOf(startTime),Integer.valueOf(endTime));
        step.setListen(listen);
    }

    /**
     * 新建Silence注入到Step中
     * @param process
     */
    private void ProcessSilence(String process) {
        step.setSilence(process);
    }

    /**
     * 将Branch添加到Step的Branch中
     * @param text
     * @param process
     */
    private void ProcessBranch(String text, String process) {
        step.setBranches(text, process);

    }

    /**
     * 将Sql语句添加到Step中
     * @param token
     * @param lineCnt
     */
    private void ProcessQuery(String token, int lineCnt) {
        token = token.substring(1,token.length() - 1);
        String[] tokens = token.split(",");
        StringBuilder sb = new StringBuilder();
        sb.append("select * from ");
        sb.append(tokens[0].substring(1,tokens[0].length() - 1));
        sb.append(" where ");
        for(int i = 1; i < tokens.length; i++){
            if(tokens[i].equals("and")){
                sb.append("and ");
            }else if(tokens[i].equals("or")){
                sb.append("or ");
            }
            sb.append(tokens[i].substring(1) + " = '%s'");
        }
        step.getSelect().setSql(sb.toString());
    }

    /**
     * 解析Exit步骤
     */
    private void ProcessExit(){
        script.setExitEntry(step.getStepId());

    }

    /**
     * 解析Default步骤
     * @param token
     */
    private void ProcessDefault(String token) {
        step.getaDefault().setNextStepID(token);
    }

}
