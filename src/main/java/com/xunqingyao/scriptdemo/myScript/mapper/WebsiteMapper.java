package com.xunqingyao.scriptdemo.myScript.mapper;

import com.xunqingyao.scriptdemo.myScript.pojo.Amount;
import com.xunqingyao.scriptdemo.myScript.pojo.Website;
import org.apache.ibatis.annotations.*;

/**
 * @Author qingyao
 * @Date 2022/11/29 15:59
 * @Version 1.0
 * @Coding utf-8
 */
@Mapper
public interface WebsiteMapper {
    @Select(value = "${sql}")
    Website select(@Param(value = "sql") String sql);

    @Update(value = "${sql}")
    void update(@Param(value = "sql") String sql);

    @Delete(value = "${sql}")
    int delete(@Param(value = "sql") String sql);

    @Insert(value = "${sql}}")
    int insert(@Param(value = "sql") String sql);

}
