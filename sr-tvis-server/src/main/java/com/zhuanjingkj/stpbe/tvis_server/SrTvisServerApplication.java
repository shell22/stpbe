package com.zhuanjingkj.stpbe.tvis_server;

import com.zhuanjingkj.stpbe.tvis_server.task.TasScheduledTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableScheduling
@EnableTransactionManagement(proxyTargetClass = true)
@ComponentScan(basePackages = {"com.zhuanjingkj.stpbe.*"})
public class SrTvisServerApplication {
    @Autowired
    private TasScheduledTask tasScheduledTask;

    public static void main(String[] args) {
        System.out.println("Traffic Video Image Structure Server v0.0.1");
        SpringApplication.run(SrTvisServerApplication.class, args);
    }

    @PostConstruct
    public void startScheduledTask() {
        Thread thd = new Thread(tasScheduledTask);
        thd.start();
    }
}
