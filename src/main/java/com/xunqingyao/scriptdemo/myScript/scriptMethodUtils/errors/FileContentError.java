package com.xunqingyao.scriptdemo.myScript.scriptMethodUtils.errors;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author qingyao
 * @Date 2022/11/12 20:32
 * @Version 1.0
 * @Coding utf-8
 */
@Slf4j
public class FileContentError extends Exception{
    int lineCnt;
    String msg;

    public FileContentError(int lineCnt, String msg){
        this.lineCnt = lineCnt;
        this.msg = msg;
        log.info("第" + lineCnt + "出现无法识别单词" + msg);
    }



}
