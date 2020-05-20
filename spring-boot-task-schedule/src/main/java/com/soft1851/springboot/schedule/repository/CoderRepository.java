package com.soft1851.springboot.schedule.repository;

import com.soft1851.springboot.schedule.model.Coder;
import com.soft1851.springboot.schedule.model.Cron;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zh_yan
 * @ClassName CoderRepository
 * @Description TODO
 * @Date 2020/5/18
 * @Version 1.0
 **/
public interface CoderRepository extends JpaRepository<Coder,Integer> {
    //更具Id查询
    Coder getOne(int Id);

    //更具cronId查询
    Coder findCoderById(int id);

}
