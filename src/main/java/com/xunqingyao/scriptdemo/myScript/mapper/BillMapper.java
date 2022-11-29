package com.xunqingyao.scriptdemo.myScript.mapper;

import com.xunqingyao.scriptdemo.myScript.pojo.Bill;
import org.apache.ibatis.annotations.*;

/**
 * @Author qingyao
 * @Date 2022/11/13 13:21
 * @Version 1.0
 * @Coding utf-8
 */
@Mapper
public interface BillMapper {

    @Select(value = "${sql}")
    Bill select(@Param(value = "sql") String sql);

    @Update(value = "${sql}")
    void update(@Param(value = "sql") String sql);

    @Delete(value = "${sql}")
    int delete(@Param(value = "sql") String sql);

    @Insert(value = "${sql}")
    int insert(@Param(value = "sql") String sql);

}
