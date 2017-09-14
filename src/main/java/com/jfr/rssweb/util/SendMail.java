package com.jfr.rssweb.util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Component;

@Component
public class SendMail {
	private String account;
	private String passWord;
	private Properties props;
	private Session session;
	/**
	 * 初始化发送邮件环境
	 * @param SMTPHost
	 * @param SMTPPort
	 * @param isSSL
	 */
	public void init(String account,String passWord,String SMTPHost,String SMTPPort,Boolean isSSL){
		this.account=account;
		this.passWord=passWord;
		this.props=new Properties();
		props.setProperty("mail.transport.protocol", "smtp");   // 使用的协议（JavaMail规范要求）
        props.setProperty("mail.smtp.host", SMTPHost);   // 发件人的邮箱的 SMTP 服务器地址
        props.setProperty("mail.smtp.auth", "true");            // 需要请求认证
        if(isSSL){
        	props.setProperty("mail.smtp.port", SMTPPort);
            props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.setProperty("mail.smtp.socketFactory.fallback", "false");
            props.setProperty("mail.smtp.socketFactory.port", SMTPPort);
        }
        this.session=Session.getDefaultInstance(props);
        this.session.setDebug(false);
	}
	/**
	 * 发送邮件函数
	 * @param from
	 * @param receiver
	 * @param title
	 * @param context
	 */
	public void sendMail(String fromName,String from,String receiver,String title,String context){
		try {
			MimeMessage message=this.createMimeMessage(fromName,from,receiver,title,context);
			Transport transport=session.getTransport();
			transport.connect(this.account,this.passWord);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (Exception e) {
		}
	}
	/**
	 * 创建Email函数
	 * @param from
	 * @param receiver
	 * @param title
	 * @param context
	 * @return
	 * @throws Exception
	 */
	private MimeMessage createMimeMessage(String fromName,String from,String receiver,String title,String context) throws Exception {
        // 1. 创建一封邮件
        MimeMessage message = new MimeMessage(this.session);
        // 2. From: 发件人（昵称有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改昵称）
        message.setFrom(new InternetAddress(from, fromName, "UTF-8"));
        // 3. To: 收件人（可以增加多个收件人、抄送、密送）
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiver, "XX用户", "UTF-8"));
        // 4. Subject: 邮件主题（标题有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改标题）
        message.setSubject(title, "UTF-8");
        // 5. Content: 邮件正文（可以使用html标签）（内容有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改发送内容）
        message.setContent(context, "text/html;charset=UTF-8");
        // 6. 设置发件时间
        message.setSentDate(new Date());
        // 7. 保存设置
        message.saveChanges();
        return message;
    }

	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
}
