package com.soft1851.springboot.schedule.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author zh_yan
 * @ClassName ScheduledConfig
 * @Description 定时任务配置
 * @Date 2020/5/14
 * @Version 1.0
 **/
//@Configuration
//public class ScheduledConfig implements SchedulingConfigurer {
//    @Override
//    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
//        scheduledTaskRegistrar.setScheduler(setTaskExecutors());
//    }
//
//    @Bean()
//    public Executor setTaskExecutors() {
//        //创建一个基本大小为3的线程池
//        return Executors.newScheduledThreadPool(3);
//    }
//}