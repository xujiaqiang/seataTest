package com.xinshen.test.serviceblcn.dao;

import com.xinshen.test.serviceblcn.model.Table;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author lzx
 * @date 2019/4/28 15:09
 */
@Mapper
public interface TableDao {
    @Insert("insert into tableb (name) values (#{name})")
    int insert(Table table);
}
