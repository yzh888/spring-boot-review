package com.soft1851.springboot.schedule.repository;

import com.soft1851.springboot.schedule.model.Cron;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author zh_yan
 * @ClassName CronRepositoryTest
 * @Description TODO
 * @Date 2020/5/15
 * @Version 1.0
 **/
@SpringBootTest
class CronRepositoryTest {
    @Resource
    private CronRepository cronRepository;

    @Test
    void findCronByCronIdEquals() {
        Cron cron = cronRepository.findCronByCronIdEquals(1);
        System.out.println(cron);
    }

    @Test
    void updateCron() {
        cronRepository.updateCron("*/8 * * * * ?", 1);
    }
}
