package com.xinshen.test.servicec.service.impl;

import com.alibaba.fescar.spring.annotation.GlobalTransactional;
import com.xinshen.test.servicec.dao.TableMapper;
import com.xinshen.test.servicec.model.Table;
import com.xinshen.test.servicec.service.ServiceBFeign;
import com.xinshen.test.servicec.service.TableService;
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
    @Autowired
    private ServiceBFeign serviceBFeign;
    @Override
//    @GlobalTransactional(name = "my_test_tx_group")
    @Transactional
    public int insert(Table table) {
        try {
            int insert = tableMapper.insert(table);
            serviceBFeign.getSeeviceBResult(table.getName());
            int i = 10 / 0;
            return insert;
        } catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("失败", e);
        }
    }
}
