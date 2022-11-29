package com.xunqingyao.scriptdemo.myScript.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

/**
 * @Author qingyao
 * @Date 2022/11/12 21:14
 * @Version 1.0
 * @Coding utf-8
 */
@Configuration(proxyBeanMethods = false)
public class MyConfig {


    @Bean
    public HashMap<Object, Object> info(){
        return new HashMap<Object, Object>();
    }

    @Bean
    public BufferedReader br() throws FileNotFoundException {
        return new BufferedReader(new FileReader(ResourceUtils.getFile("classpath:testB.txt")));
    }


    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druid(){
        return new DruidDataSource();
    }
}
