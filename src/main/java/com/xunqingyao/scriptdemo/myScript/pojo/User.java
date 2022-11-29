package com.xunqingyao.scriptdemo.myScript.pojo;

import lombok.Data;
import lombok.ToString;

/**
 * @Author qingyao
 * @Date 2022/11/13 12:56
 * @Version 1.0
 * @Coding utf-8
 */

@Data
@ToString
public class User {
    String id;
    String name;
    String password;
}
