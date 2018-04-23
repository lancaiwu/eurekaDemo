package com.example.quartz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 简单 Quartz-Cluster 微服务，采用注解配置 Quartz 分布式集群。
 *
 * @author hmilyylimh
 * @version 0.0.1
 * @date 2017/12/17
 */
@SpringBootApplication
public class QuartzApplication {

    private static final Logger logger = LoggerFactory.getLogger(QuartzApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(QuartzApplication.class, args);
        logger.info("【【【【【【 简单Quartz-Config-Cluster微服务 】】】】】】已启动.");
    }
}
