package com.soft1851.springboot.schedule.task;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import cn.hutool.http.HttpUtil;
import com.google.zxing.qrcode.encoder.QRCode;
import com.soft1851.springboot.schedule.model.Coder;
import com.soft1851.springboot.schedule.repository.CoderRepository;
import jdk.jfr.Enabled;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author zh_yan
 * @ClassName MultithreadScheduleTask
 * @Description 多线程异步任务
 * @Date 2020/5/17
 * @Version 1.0
 **/
@Component
@EnableScheduling
@Slf4j
public class MultithreadScheduleTask {
    @Resource
    private CoderRepository coderRepository;

    @Async
    @Scheduled(fixedRate = 1000)
    public void first() {
        Console.log("第一个异步定时任务,{},当前线程：{}", DateUtil.now(),Thread.currentThread().getName());
    }

    @Async
    @Scheduled(fixedRate = 3000)
    public void second() {
        Console.log("第二个异步定时任务,{},当前线程：{}", RandomUtil.randomInt(10,100),Thread.currentThread());
    }

    @Async
    @Scheduled(fixedDelay = 2000)
    public void getCoder() {
        Console.log("第二个异步定时任务,{},当前线程：{}", RandomUtil.randomInt(10,100),Thread.currentThread());
    }

    @Async
    public void getQrCode(String url ,String path1) {
        System.out.println(url);
        //设置二维码格式
        QrConfig config = new QrConfig(500, 500);
        //设置外边距
        config.setMargin(2);
        String random = IdUtil.simpleUUID();
        String path = "d:/code/" + random + ".jpg";
        QrCodeUtil.generate(//
                "http://www.baidu.com", //二维码内容
                config.setImg(url), //附带logo
                FileUtil.file(path)//写出到的文件
        );}

    @Async
    public void download() {
        Coder coder1 = coderRepository.findCoderById(1);
        String template = "D:/code/{}.jpg";
        String path = StrUtil.format(template, IdUtil.simpleUUID());
        HttpUtil.downloadFile(coder1.getAvatar(), FileUtil.file(path));
        System.out.println(coder1.getAvatar());
        getQrCode(coder1.getUrl(),path);
    }

   public static void main(String[] args) {new MultithreadScheduleTask().download();}

}
