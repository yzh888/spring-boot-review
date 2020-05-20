package com.soft1851.springboot.schedule.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author zh_yan
 * @ClassName Coder
 * @Description TODO
 * @Date 2020/5/18
 * @Version 1.0
 **/
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Coder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name", nullable = false, length = 30)
    private String name ;
    @Column(name = "avatar", nullable = false, length = 200)
    private String avatar;
    @Column(name = "url", nullable = false, length = 50)
    private String url;
}
