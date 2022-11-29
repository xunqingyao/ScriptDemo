package com.xunqingyao.scriptdemo.myScript.scriptMethodUtils.errors;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author qingyao
 * @Date 2022/11/12 19:53
 * @Version 1.0
 * @Coding utf-8
 */
@Slf4j
public class MyIOError extends Exception{
    /**
     * 异常信息
     */
    String msg;
    /**
     * 不同的情况的IO异常设置不同的level等级
     */
    int level;

    public MyIOError() {

    }
    public MyIOError(int level){
        this.level = level;
        setMsgByLevel(level);
        log.info(msg);
    }

    private void setMsgByLevel(int level) {
        switch(level){
            case 1:
                msg = "文件打开异常，该文件不是指定文件";break;
            case 2:
                msg = "文件读取异常，文件内容异常";break;
            case 3:
                msg = "文件关闭异常";break;
            default:
                break;
        }
    }
}
