package com.cms.user.timer;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Timer {

    // 每分钟执行一次
    @Scheduled(cron = "0 * * * * ?")
    public void testTimer() {
        System.out.println(System.currentTimeMillis());
    }

}
