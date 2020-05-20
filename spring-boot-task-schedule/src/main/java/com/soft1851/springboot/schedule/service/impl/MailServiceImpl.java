package com.soft1851.springboot.schedule.service.impl;

import com.soft1851.springboot.schedule.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.lang.annotation.Retention;
import java.util.Map;

/**
 * @author zh_yan
 * @ClassName MailServiceImpl
 * @Description TODO
 * @Date 2020/5/15
 * @Version 1.0
 **/
@Service
@Slf4j
public class MailServiceImpl implements MailService {
    //读入配置文件中的邮箱发送者设置
    @Value("${spring.mail.username}")
    private String from;
    @Resource
    private JavaMailSender mailSender;

    @Override
    public void sendSimpleTextMail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        message.setFrom(from);
        mailSender.send(message);
        log.info("文本邮件发送成功！to={}",to);
    }
    @Override
    public void sendHtmlMail(String to, String subject, String content) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
        messageHelper.setFrom(from);
        messageHelper.setTo(to);
        messageHelper.setSubject(subject);
        //true为html事件
        messageHelper.setText(content, true);
        mailSender.send(message);
        log.info("[html]文本邮件发送成功！to={}",to);

    }
    @Override
    public void sendAttachmentMail(String to, String subject, String content, String... fileArr)
            throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
        messageHelper.setFrom(from);
        messageHelper.setTo(to);
        messageHelper.setSubject(subject);
        messageHelper.setText(content, true);
// 添加附件
        for (String filePath : fileArr) {
            FileSystemResource fileResource = new FileSystemResource(new File(filePath));
            if (fileResource.exists()) {
                String fileName = fileResource.getFilename();
                assert fileName != null;
                messageHelper.addAttachment(fileName, fileResource);
            }
        }
        mailSender.send(mimeMessage);
        log.info(" [附件邮件]成功发送! to={}", to);
    }
    @Override
    public void sendImgMail(String to, String subject, String content, Map<String, String> imgMap)
            throws MessagingException {
        MimeMessage mimeMessage = mailSender . createMimeMessage( ) ;
        MimeMessageHelper messageHelper = new MimeMessageHelper (mimeMessage,  true);
        messageHelper.setFrom(from);
        messageHelper.setTo(to);
        messageHelper.setSubject(subject);
        messageHelper.setText( content, true);
//添加图片
        for (Map . Entry<String, String> entry : imgMap.entrySet()) {
            FileSystemResource fileResource = new FileSystemResource(new File(entry.getValue()));
            if (fileResource.exists()) {
                messageHelper.addInline(entry.getKey(), fileResource);
            }
            }
            mailSender.send(mimeMessage);
            log.info(" [图片邮件]成功发送! to={}", to);
        }
}
