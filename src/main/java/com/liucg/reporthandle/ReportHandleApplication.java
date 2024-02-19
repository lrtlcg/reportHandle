package com.liucg.reporthandle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@EnableScheduling //定时任务计划注解
 public class ReportHandleApplication extends SpringBootServletInitializer {
    /**
     * 1、启动类继承SpringBootServletInitializer
     * 2、重写configure方法
     * @description:
     * @author: liucg
     * @date: 2024年2月15日上午
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ReportHandleApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ReportHandleApplication.class, args);
    }

}

//public class ReportHandleApplication {
//
//    public static void main(String[] args) {
//        SpringApplication.run(ReportHandleApplication.class, args);
//    }
//
//}
