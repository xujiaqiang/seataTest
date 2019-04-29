package com.xinshen.test.serviceblcn.controller;

import com.xinshen.test.serviceblcn.model.Table;
import com.xinshen.test.serviceblcn.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lzx
 * @date 2019/4/28 15:15
 */
@RestController
public class TableController {

    @Autowired
    private TableService tableService;

    @RequestMapping("/demoinsert/{name}")
    public int demoinsert(@PathVariable("name") String name) {
        Table table = new Table();
        table.setName(name);
        try {
            int insert = tableService.insert(table);
            return insert;
        } catch (Exception e) {
            return 12345;
        }
    }
}
