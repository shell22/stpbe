package com.zhuanjingkj.stpbe.tmdp;

import com.zhuanjingkj.stpbe.common.AppConst;
import com.zhuanjingkj.stpbe.common.AppRegistry;
import com.zhuanjingkj.stpbe.tmdp.controller.TmdpWsHandler;
import com.zhuanjingkj.stpbe.tmdp.task.VideoAnalysisTask;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableDiscoveryClient
@EnableTransactionManagement(proxyTargetClass = true)
@ComponentScan(basePackages = {"com.zhuanjingkj.stpbe.tmdp.*"})
@MapperScan({"com.zhuanjingkj.stpbe.tmdp.mapper", "com.zhuanjingkj.stpbe.common.mapper"})
@EnableScheduling
public class MsTmdpApplication {
    public static ConfigurableApplicationContext appCtx = null;

    public static void main(String[] args) {
        TmdpWsHandler.initialize();
        MsTmdpApplication.appCtx = SpringApplication.run(MsTmdpApplication.class, args);
        AppRegistry.putParam(AppConst.APP_CTX, MsTmdpApplication.appCtx);
    }
}
