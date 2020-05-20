package com.soft1851.springboot.schedule.repository;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import cn.hutool.http.HttpUtil;
import com.soft1851.springboot.schedule.model.Coder;
import com.soft1851.springboot.schedule.model.Cron;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author zh_yan
 * @ClassName CoderRepositoryTest
 * @Description TODO
 * @Date 2020/5/18
 * @Version 1.0
 **/
@SpringBootTest
class CoderRepositoryTest {
    @Resource
    private CoderRepository coderRepository;

    @Test
    void download() {
        Coder coder1 = coderRepository.findCoderById(1);
        System.out.println("11111111122222");
        System.out.println(coder1.getAvatar());
        String template = "D:/code/{}.jpg";
        String path = StrUtil.format(template, IdUtil.simpleUUID());
        HttpUtil.downloadFile(coder1.getAvatar(), FileUtil.file(path));
    }

    @Test
    void getQrCode() {
        String url = "http://ww1.sinaimg.cn/large/007YO3iLgy1gcvrr2bfxfj31hc0xcn2u.jpg";
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
        );

    }
}
