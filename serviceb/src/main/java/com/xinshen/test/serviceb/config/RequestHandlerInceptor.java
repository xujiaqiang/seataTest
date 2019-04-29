package com.xinshen.test.serviceb.config;

import com.alibaba.fescar.core.context.RootContext;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

/**
 * @author lzx
 * @date 2019/4/27 22:49
 */
@Component
public class RequestHandlerInceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        String xid = RootContext.getXID();
        if(StringUtils.isNotBlank(xid)){
            requestTemplate.header("Fescar-Xid",xid);
        }
    }
}
