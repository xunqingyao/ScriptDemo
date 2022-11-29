package com.xunqingyao.scriptdemo.myScript.pojo;

import lombok.Data;
import lombok.ToString;

/**
 * @Author qingyao
 * @Date 2022/11/13 13:15
 * @Version 1.0
 * @Coding utf-8
 */
@Data
@ToString
public class Bill {
    String id;
    Integer billOutTimes;
    Integer billOutMoney;
    Integer billInTimes;
    Integer billInMoney;
}
