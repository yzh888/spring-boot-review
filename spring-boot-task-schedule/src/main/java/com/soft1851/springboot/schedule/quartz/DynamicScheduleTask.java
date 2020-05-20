package com.soft1851.springboot.schedule.quartz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.SchedulerException;

/**
 * @author zh_yan
 * @ClassName DynamicScheduleTask
 * @Description
 * @Date 2020/5/18
 * @Version 1.0
 **/
@Slf4j
public class DynamicScheduleTask {
    public static void main(String[] args) throws SchedulerException {
        //添加任务，注意各个参数的作用
        QuartzManager.addJob("testJob","jobGroup1",
                "testTrigger","triggerGroup1",
                TestJob.class,"0/5 * * * * ?");

        //修改任务
//        QuartzManager.modifyJobTime("testTrigger","triggerGroup1",5);
//        try {
//            Thread.sleep(8000);
//        }catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        //删除任务
//        QuartzManager.removeJob("testJob","jobGroup1",
//                "testTrigger","triggerGroup1");
//        QuartzManager.shutdownJobs();


    }

}
