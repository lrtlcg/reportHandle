package com.liucg.reporthandle.pub;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig{

    @Bean
    @ConfigurationProperties(prefix="spring.datasource.one")//@ConfigurationProperties 是 Spring Boot 提供的类型安全的属性绑定
    DataSource dsOne(){ //表示使用 spring.datasource.one 前缀的数据库配置去创建一个 DataSource
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix="spring.datasource.two")
    DataSource dsTwo(){
        return DruidDataSourceBuilder.create().build();
    }
}
