package com.ws.util;


// ��Ҫ�û��������ʼ�����ʵ��
//�ļ��� SendEmail2.java
//��ʵ����QQ����Ϊ������Ҫ��qq��̨����
import java.security.GeneralSecurityException;
import java.util.Properties;
 


import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;
 
public class SendQQMail{
	
	public static void main(String[] args) {
		String content = "您在校园二手网站发布的商品已经被被购买,请及时发货!"
				+"<a href='http://localhost:8080/SchoolSecondHandWeb/SchoolSecondHandWeb/main'>"
				+ "点击查看</a>";
		String email = "849307440@qq.com";
		try {
			System.out.println(sendMail(email, content));;
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
   public static String sendMail(String email,String content) throws GeneralSecurityException{
	   
	  String returnMessage = "";
      // �ռ��˵�������
//      String to = "849307440@qq.com";
 
      // �����˵�������
      String from = "849307440@qq.com";
 
      // ָ�������ʼ�������Ϊ smtp.qq.com
      String host = "smtp.qq.com";  //QQ �ʼ�������
 
      // ��ȡϵͳ����
      Properties properties = System.getProperties();
      
      // �����ʼ�������
      properties.setProperty("mail.smtp.host", host);
 
      properties.put("mail.smtp.auth", "true");
      
	   // ����QQ���䣬��Ҫ����SSL���ܣ��������´��뼴��
	   MailSSLSocketFactory sf = new MailSSLSocketFactory();
	   sf.setTrustAllHosts(true);
	   properties.put("mail.smtp.ssl.enable", "true");
	   properties.put("mail.smtp.ssl.socketFactory", sf);
	      
      // ��ȡĬ��session����
      Session session = Session.getDefaultInstance(properties,new Authenticator(){
	        public PasswordAuthentication getPasswordAuthentication(){
	        	return new PasswordAuthentication("849307440@qq.com", "ttuwqraoharhbbcd"); //�������ʼ��û�������
	        }
      });
 
      try{
         // ����Ĭ�ϵ� MimeMessage ����
         MimeMessage message = new MimeMessage(session);
 
         // Set From: ͷ��ͷ�ֶ�
         message.setFrom(new InternetAddress(from));
 
         // Set To: ͷ��ͷ�ֶ�
         message.addRecipient(Message.RecipientType.TO,
                                  new InternetAddress(email));
 
         // Set Subject: ͷ��ͷ�ֶ�
         message.setSubject("SchoolSecondHandWeb");
 
         // ������Ϣ��
         message.setText(content);
 
         // ������Ϣ
         Transport.send(message);
         System.out.println("Sent message successfully....from runoob.com");
         returnMessage = "邮件发送成功";
      }catch (MessagingException mex) {
         mex.printStackTrace();
         returnMessage = "邮件发送失败!";
      }
      return returnMessage;
   }
   
}