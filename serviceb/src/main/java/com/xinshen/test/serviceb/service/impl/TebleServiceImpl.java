package com.xinshen.test.serviceb.service.impl;

import com.alibaba.fescar.spring.annotation.GlobalTransactional;
import com.xinshen.test.serviceb.dao.TableMapper;
import com.xinshen.test.serviceb.model.Table;
import com.xinshen.test.serviceb.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lzx
 * @date 2019/4/26 19:00
 */
@Service
public class TebleServiceImpl implements TableService {
    @Autowired
    private TableMapper tableMapper;
    @Override
//    @Transactional
    @GlobalTransactional(name = "my_test_tx_group")
    public int insert(Table table) {
        try {
            int insert = tableMapper.insert(table);
            return insert;
//            int i = 10 / 0;
        } catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("失败");
        }
    }
}
