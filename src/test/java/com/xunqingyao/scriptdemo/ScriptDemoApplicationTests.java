package com.xunqingyao.scriptdemo;

import com.xunqingyao.scriptdemo.myScript.scriptMethodUtils.interprete.Interpreter;
import com.xunqingyao.scriptdemo.myScript.scriptMethodUtils.parse.Parser;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest()
class ScriptDemoApplicationTests {

    @Autowired
    Parser parser;

    @Autowired
    HashMap<Object, Object> info;

    @Autowired
    BufferedReader br;

    @Autowired
    Interpreter interpreter;

    @Test
    void TestA() throws IOException {
        interpreter.disposeExegesis();
        String url = "classpath:aaa.txt";
        parser.ParseFile(url);
        while(true){
            interpreter.procedure();
        }
    }
    @Test
    void TestB() throws IOException {
        interpreter.disposeExegesis();
        String url = "classpath:bbb.txt";
        parser.ParseFile(url);
        while(true){
            interpreter.procedure();
        }
    }
}
