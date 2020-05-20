package com.soft1851.springboot.schedule.service;

import javax.mail.MessagingException;
import java.util.Map;

/**
 * @author zh_yan
 * @ClassName MailService
 * @Description 发送简单的文本邮件
 * @Date 2020/5/15
 * @Version 1.0
 **/
public interface MailService {
    //发送简单的文本邮件
    void sendSimpleTextMail(String to, String subject, String content);
    //html
    void sendHtmlMail(String to, String subject, String content) throws MessagingException;
    //附件邮件
    void sendAttachmentMail(String to, String subject, String content, String... fileArr)throws MessagingException;
    //图片
    void sendImgMail(String to, String subject, String content, Map<String, String> imgMap) throws MessagingException;
}
