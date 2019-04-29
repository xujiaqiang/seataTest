package com.xinshen.test.serviceb.controller;

import com.xinshen.test.serviceb.model.Table;
import com.xinshen.test.serviceb.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lzx
 * @date 2019/4/27 11:54
 */
@RestController
public class ServiceBController {

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
            return 999;
        }
    }

}
