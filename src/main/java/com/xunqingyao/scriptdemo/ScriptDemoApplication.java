package com.xunqingyao.scriptdemo;

import com.xunqingyao.scriptdemo.myScript.scriptMethodUtils.interprete.Interpreter;
import com.xunqingyao.scriptdemo.myScript.scriptMethodUtils.parse.Parser;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

@MapperScan(value = {"com.xunqingyao.scriptdemo.myScript.mapper"})
@SpringBootApplication
@Slf4j
public class ScriptDemoApplication {


    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext run = SpringApplication.run(ScriptDemoApplication.class, args);
    }

}
