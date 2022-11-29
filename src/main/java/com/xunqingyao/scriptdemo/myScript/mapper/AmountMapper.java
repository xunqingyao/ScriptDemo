package com.xunqingyao.scriptdemo.myScript.mapper;

import com.xunqingyao.scriptdemo.myScript.pojo.*;
import org.apache.ibatis.annotations.*;

/**
 * @Author qingyao
 * @Date 2022/11/13 13:32
 * @Version 1.0
 * @Coding utf-8
 */
@Mapper
public interface AmountMapper {
    @Select(value = "${sql}")
    Amount select(@Param(value = "sql") String sql);

    @Update(value = "${sql}")
    void update(@Param(value = "sql") String sql);

    @Delete(value = "${sql}")
    int delete(@Param(value = "sql") String sql);

    @Insert(value = "${sql}}")
    int insert(@Param(value = "sql") String sql);

}
