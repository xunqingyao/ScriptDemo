package com.xunqingyao.scriptdemo.myScript.scriptMethodUtils.interprete;

import com.xunqingyao.scriptdemo.myScript.mapper.AmountMapper;
import com.xunqingyao.scriptdemo.myScript.mapper.BillMapper;
import com.xunqingyao.scriptdemo.myScript.mapper.UserMapper;
import com.xunqingyao.scriptdemo.myScript.mapper.WebsiteMapper;
import com.xunqingyao.scriptdemo.myScript.pojo.Amount;
import com.xunqingyao.scriptdemo.myScript.pojo.Bill;
import com.xunqingyao.scriptdemo.myScript.pojo.Website;
import com.xunqingyao.scriptdemo.myScript.scriptMethodUtils.AST.MyAST;
import com.xunqingyao.scriptdemo.myScript.scriptMethodUtils.AST.Script;
import com.xunqingyao.scriptdemo.myScript.scriptMethodUtils.AST.Step;
import com.xunqingyao.scriptdemo.myScript.scriptMethodUtils.AST.innerclass.InputContent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * @Author qingyao
 * @Date 2022/11/14 15:03
 * @Version 1.0
 * @Coding utf-8
 */
@Slf4j
@Component
public class Interpreter {

    @Autowired
    MyAST myAST;

    @Autowired
    Script script;

    @Autowired
    BufferedReader br;


    @Autowired
    AmountMapper amountMapper;

    @Autowired
    BillMapper billMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    WebsiteMapper websiteMapper;

    @Autowired
    HashMap<Object, Object> info;


    private Step step;
    private String stepID;
    private String nextStepID;

    public void disposeExegesis() throws IOException {
        while(true) {
            String str = br.readLine();
            br.mark(10000);
            if(str.substring(0,2).equals("//")) {
                str = str.substring(2);
                String[] properties = str.split(" ");
                for (int i = 0; i < properties.length; i++) {
                    String[] property = properties[i].split("=");
                    info.put(property[0], property[1]);
                }
                break;
            }
        }
        br.reset();
    }


    /**
     * ?????????????????? ????????????????????????step????????????????????????????????????????????????
     * @throws IOException
     */
    public void procedure() throws IOException {


        /**
         * ??????????????????step????????????step
         */
        if(nextStepID == null) {
            stepID = script.getEntry();
        }else{
            stepID = nextStepID;
        }
        step = script.getSteps().get(stepID);

        /**
         * ???????????????step????????????????????????????????????????????????
         */
        if(step.getaDefault().getNextStepID() != null){
            nextStepID = step.getaDefault().getNextStepID();
        }

        /**
         * ???input???????????????
         */
        if(!step.getInputContent().getName().isEmpty()){
            String sqlArgs = getFileContent();
            info.put("sqlArgs",sqlArgs);
        }

        /**
         * ?????????????????????????????????????????????????????????step?????????select???????????????????????????????????????
         */
        if(step.getSelect().getSql() != null){
            String sql = step.getSelect().getSql();
            String[] tokens = sql.split(" ");
            String[] sqlArgs = ((String)info.get("sqlArgs")).split(" ");
            sql = String.format(sql, sqlArgs);
            executeSelectSql(tokens[3],sql);
        }

        /**
         * ????????????????????????Speak?????????step??????expression?????????context?????????????????????Speak
         * ????????????Speak??????????????????????????????????????????????????????
         */
        if(step.getExpression().getSpeakContent() != null){
            log.info(getExpressionText(step.getExpression().getSpeakContent()));
        }

        /**
         * Listen??????
         *
         */
        if(step.getListen().getStartTime() != step.getListen().getEndTime()){
            if(!step.getBranches().isEmpty()){
                String branch = getFileContent();
                info.put("branch", branch);
                selectBranch();
            }else{
                getCustomerContext();
            }
        }
        /**
         * ??????stepID???????????????step???????????????????????????session???script
         */
        if(stepID.equals(script.getExitEntry())){
            log.info("????????????");
            System.exit(0);
        }

    }

    /**
     * ????????????????????????????????????????????????????????????????????????
     * @throws IOException
     */
    private void getCustomerContext() throws IOException {
        String str = br.readLine();
    }

    /**
     * ??????????????????
     * @return
     * @throws IOException
     */
    private String getFileContent() throws IOException {
        String str = br.readLine();
        return str;
    }

    /**
     * ???????????????????????????????????????
     * @return ????????????
     */
    public String selectBranch(){
        String branch = (String) info.get("branch");
        if(branch != null){
            if(branch.length() == 0) {
                nextStepID = step.getSilence().getNextStepID();
            }else if(step.getBranches().containsKey(branch)){
                nextStepID = step.getBranches().get(branch);
            }
        }
        return nextStepID;
    }

    /**
     * ??????sql??????
     * @param table ???????????????
     * @param sql sql??????
     */
    public void executeSelectSql(String table,String sql){
        switch(table){
            case "bill" : {
                Bill bill = billMapper.select(sql);
                info.put("bill_out_times", bill.getBillOutTimes());
                info.put("bill_in_times", bill.getBillInTimes());
                info.put("bill_out_money", bill.getBillOutMoney());
                info.put("bill_in_money", bill.getBillInMoney());
                break;
            }
            case "amount": {
                Amount amount = amountMapper.select(sql);
                info.put("balance",amount.getBalance());
                break;
            }
            case "website":{
                Website website = websiteMapper.select(sql);
                info.put("ip", website.getIp());
                break;
            }
            default:
                break;
        }
    }

    /**
     * ??????expression????????????
     * @param text
     * @return
     */
    public String getExpressionText(String text){
        StringBuilder sb = new StringBuilder();
        String[] texts = text.split(" ");
        for(String s : texts){
            if(s.charAt(0) == '$'){
                if(info.get(s.substring(1)) != null){
                    sb.append(info.get(s.substring(1)));
                }else{
                    sb.append(info.get(s.substring(1)));
                }
            }else if("+".equals(s)){
                continue;
            }else{
                sb.append(s.substring(1,s.length() - 1));
            }
        }
        return sb.toString();

    }

}
