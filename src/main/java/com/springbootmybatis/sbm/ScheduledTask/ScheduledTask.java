package com.springbootmybatis.sbm.ScheduledTask;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

/**
 * @author 11030
 */
@Component
public class ScheduledTask {

    @PostConstruct
    @Scheduled(cron = " 0 30 9 ? * *")
    public void scheduledTask() {
        System.out.println("10点了。。。");
        System.out.println("任务执行时间：" + LocalDateTime.now());
    }

}

