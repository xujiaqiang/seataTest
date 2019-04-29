package com.xinshen.test.serviceblcn.service.impl;

import com.codingapi.txlcn.tc.annotation.DTXPropagation;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.codingapi.txlcn.tc.annotation.TxcTransaction;
import com.xinshen.test.serviceblcn.dao.TableDao;
import com.xinshen.test.serviceblcn.model.Table;
import com.xinshen.test.serviceblcn.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lzx
 * @date 2019/4/28 15:12
 */
@Service
public class TableServiceImpl implements TableService {

    @Autowired
    private TableDao tableDao;
    @Override
    @Transactional
    @LcnTransaction
    public int insert(Table table) {
        try {
            int insert = tableDao.insert(table);
//            int i = 10 / 0;
            return insert;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
