package com.xinshen.test.serviceb.dao;

import com.xinshen.test.serviceb.model.Table;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author lzx
 * @date 2019/4/26 18:56
 */
@Mapper
public interface TableMapper {
    @Insert("insert into tableb (name) values (#{name})")
    int insert(Table table);
}
