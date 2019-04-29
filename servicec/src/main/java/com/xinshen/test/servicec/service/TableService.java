package com.xinshen.test.servicec.service;

import com.xinshen.test.servicec.model.Table;
import javafx.scene.control.Tab;
import org.springframework.stereotype.Service;

/**
 * @author lzx
 * @date 2019/4/26 18:59
 */
public interface TableService {

    int insert(Table table);
}
