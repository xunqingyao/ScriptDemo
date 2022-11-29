package com.xunqingyao.scriptdemo.myScript.scriptMethodUtils.AST;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author qingyao
 * @Date 2022/11/12 22:21
 * @Version 1.0
 * @Coding utf-8
 */
@Component
public class Script {
    private HashMap<String, Step> steps = new HashMap<>();
    List<String> varNames = new ArrayList<>();
    String entry;
    String exitEntry;
    public String getExitEntry() {
        return exitEntry;
    }

    public void setExitEntry(String exitEntry) {
        this.exitEntry = exitEntry;
    }




    @Override
    public String toString() {
        return "Script{" +
                "steps=" + steps +
                ", varNames=" + varNames +
                ", entry='" + entry + '\'' +
                '}';
    }

    public HashMap<String, Step> getSteps() {
        return steps;
    }

    public void setSteps(String stepID, Step step   ) {
        steps.put(stepID, step);
    }

    public List<String> getVarNames() {
        return varNames;
    }

    public void setVarNames(List<String> varNames) {
        this.varNames = varNames;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public Script() {
    }
}
