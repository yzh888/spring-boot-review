package com.soft1851.springboot.jpa.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author zh_yan
 * @ClassName Teacher
 * @Description TODO
 * @Date 2020/5/14
 * @Version 1.0
 **/
@Entity
@Data
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "teacher_name", nullable = false, length = 30)
    private String teacherName;

    @OneToOne(cascade = CascadeType.ALL) //增删改的时候可以级联
    @JoinColumn(name = "clazz_id", referencedColumnName = "id")
    private Clazz clazz;
}
