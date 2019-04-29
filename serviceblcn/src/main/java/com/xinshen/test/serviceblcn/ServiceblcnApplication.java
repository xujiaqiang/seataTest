package com.xinshen.test.serviceblcn;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableDistributedTransaction
public class ServiceblcnApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceblcnApplication.class, args);
    }

}
