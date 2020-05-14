package com.soft1851.springboot.jpa.repository;

import com.soft1851.springboot.jpa.model.Clazz;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zh_yan
 * @ClassName ClazzRepository
 * @Description TODO
 * @Date 2020/5/14
 * @Version 1.0
 **/
public interface ClazzRepository extends JpaRepository<Clazz, Integer> {
    /**
     * 根据id查询班级
     *
     * @param id
     * @return
     */
    Clazz findClazzByIdEquals(int id);
}