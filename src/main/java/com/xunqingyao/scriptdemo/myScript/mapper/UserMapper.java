package com.xunqingyao.scriptdemo.myScript.mapper;

import com.xunqingyao.scriptdemo.myScript.pojo.User;
import org.apache.ibatis.annotations.*;

/**
 * @Author qingyao
 * @Date 2022/11/13 13:17
 * @Version 1.0
 * @Coding utf-8
 */
@Mapper
public interface UserMapper{
    @Select(value = "${sql}")
    User select(@Param(value = "sql") String sql);

    @Update(value = "${sql}")
    void update(@Param(value = "sql") String sql);

    @Delete(value = "${sql}")
    int delete(@Param(value = "sql") String sql);

    @Insert(value = "${sql}}")
    int insert(@Param(value = "sql") String sql);
}
