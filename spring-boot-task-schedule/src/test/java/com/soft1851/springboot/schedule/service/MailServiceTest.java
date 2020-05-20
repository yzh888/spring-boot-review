package com.soft1851.springboot.schedule.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zh_yan
 * @ClassName MailServiceTest
 * @Description TODO
 * @Date 2020/5/15
 * @Version 1.0
 **/
@SpringBootTest
public class MailServiceTest {
    @Resource
    private MailService mailService;

    @Test
    void sendSimpleTextMail() {
        String to = "3149991705@qq.com";
        String subject = "简单文本邮件";
        String content = "<h3>第一封简单邮件<h3>";
        mailService.sendSimpleTextMail(to,subject,content);
    }
    @Test
    void sendHtmlMail() throws Exception{
        String to = "3149991705@qq.com";
        String subject = "html邮件";
        String content = "<h3>第一封简单html邮件</h3>";
        mailService.sendHtmlMail(to,subject,content);
    }
    @Test
    void sendAttachmentMail() throws Exception{
        String to = "3149991705@qq.com";
        String subject = "附件邮件";
        String content = "<h3>第一封简单附件邮件</h3>";
        String filePath = "pom.xml";
        mailService.sendAttachmentMail(to,subject,content,filePath,filePath);
    }
    @Test
    void sendImgMail() throws Exception{
        String to = "3149991705@qq.com";
        String subject = "图片邮件";
        String content = "<h3>第一封简单图片邮件</h3><img src=\"cid:img01\" />";
        String imgPath = "1.png";
        Map<String, String> imgMap = new HashMap<>();
        //一键值对的形式存入
        imgMap.put("img01",imgPath);
        mailService.sendImgMail(to,subject,content,imgMap);
    }

}
