package com.xinshen.test.servicec.controller;

import com.xinshen.test.servicec.model.Table;
import com.xinshen.test.servicec.service.TableService;
import com.xinshen.test.servicec.service.impl.TebleServiceImpl;
import org.bouncycastle.jcajce.provider.symmetric.TEA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lzx
 * @date 2019/4/27 11:59
 */
@RestController
public class SericeCController {

    @Autowired
    private TableService tableService;

    @RequestMapping("/test/{name}")
    public int test(@PathVariable("name") String name) {
        Table table = new Table();
        table.setName(name);
        try {
            int insert = tableService.insert(table);
            return insert;
        } catch (Exception e) {
            e.printStackTrace();
            return 12345;
        }

    }
}
