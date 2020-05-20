package com.soft1851.springboot.schedule.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author zh_yan
 * @ClassName AsyncTaskService
 * @Description TODO
 * @Date 2020/5/16
 * @Version 1.0
 **/
@Service
@Slf4j
public class AsyncTaskService {
    @Async
    public void asyncTask() {
        try {
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }
        log.info("数据处理中");
    }
}
