package com.xinshen.test.servicec.service;

import com.xinshen.test.servicec.model.Table;
import javafx.scene.control.Tab;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lzx
 * @date 2019/4/27 11:52
 */
@FeignClient(value = "serviceb")
public interface ServiceBFeign {

    @RequestMapping("/test/{name}")
    int getSeeviceBResult(@PathVariable("name") String name);
}
