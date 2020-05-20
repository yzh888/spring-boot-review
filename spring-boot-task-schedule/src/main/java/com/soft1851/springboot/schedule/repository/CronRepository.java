package com.soft1851.springboot.schedule.repository;

import com.soft1851.springboot.schedule.model.Cron;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zh_yan
 * @ClassName CronRepository
 * @Description TODO
 * @Date 2020/5/15
 * @Version 1.0
 **/
public interface CronRepository extends JpaRepository<Cron,Integer> {
    //更具cronId查询
    Cron findCronByCronIdEquals(int cronId);

    //根据id修改cron
    @Modifying
    @Transactional(rollbackFor = RuntimeException.class)
    @Query(value = "update cron set cron = ?1 where cron_id = ?2", nativeQuery = true)
    void updateCron(String cron,int id);
}
