package com.soft1851.springboot.quartz.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zh_yan
 * @ClassName InternalApiController
 * @Description TODO
 * @Date 2020/5/19
 * @Version 1.0
 **/
@RestController
public class InternalApiController {

    @GetMapping("/internal/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("这是内部接口");
    }
}