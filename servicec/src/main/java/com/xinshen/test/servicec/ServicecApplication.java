package com.xinshen.test.servicec;

import com.alibaba.druid.pool.DruidDataSource;
import com.xinshen.test.servicec.config.FescarXidFilter;
import com.xinshen.test.servicec.config.RequestHandlerInceptor;
import feign.RequestInterceptor;
import io.seata.rm.datasource.DataSourceProxy;
import io.seata.spring.annotation.GlobalTransactionScanner;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.xinshen.test.servicec.dao")
public class ServicecApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServicecApplication.class, args);
    }

//    @Bean
////    @ConfigurationProperties(prefix = "spring.datasource")
//    public DruidDataSource druidDataSource() {
//        DruidDataSource druidDataSource = new DruidDataSource();
//        return druidDataSource;
//    }
//
//    @Primary
//    @Bean("dataSource")
//    public DataSourceProxy dataSource(DruidDataSource druidDataSource) {
//        return new DataSourceProxy(druidDataSource);
//    }

    @Bean(destroyMethod = "close", initMethod = "init")
    @ConfigurationProperties(prefix="spring.datasource")
    public DruidDataSource druidDataSource() {

        return new DruidDataSource();
    }


    @Bean
    public DataSourceProxy dataSourceProxy(DruidDataSource druidDataSource) {

        return new DataSourceProxy(druidDataSource);
    }


    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSourceProxy dataSourceProxy) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSourceProxy);
        return factoryBean.getObject();
    }

    @Bean
    public GlobalTransactionScanner globalTransactionScanner() {
        return new GlobalTransactionScanner("serviceb", "my_test_tx_group");
    }


    @Bean
    public RequestInterceptor requestInterceptor(){
        return new RequestHandlerInceptor();
    }
    @Bean
    public FescarXidFilter fescarXidFilter(){
        return new FescarXidFilter();
    }

}
