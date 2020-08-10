package com.jie;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

/**
 * @description:
 * @author: yanghaojie 31648
 * @date: 2020/8/7 15:09
 */
@SpringBootApplication
@Slf4j
public class RecruitApplication {
    public static void main(String[] args) {
//        SpringApplication.run(BaseApplication.class,args);
        Environment environment = SpringApplication.run(RecruitApplication.class,args).getEnvironment();
        log.info("启动成功!访问地址: http://127.0.0.1:" + environment.getProperty("server.port") + "/login/login");
    }

}
