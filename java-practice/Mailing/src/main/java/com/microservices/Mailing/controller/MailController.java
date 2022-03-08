package com.microservices.Mailing.controller;

import java.io.IOException;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@Configuration
public class MailController implements CommandLineRunner {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void run(String... args) throws MessagingException, IOException{
		System.out.println("Sending mail started..");
		
		sendEmailWithAttachment();
		
		System.out.println("Done");
	}
	
	private void sendEmailWithAttachment() throws MessagingException, IOException {
		MimeMessage mimeMsg = javaMailSender.createMimeMessage();
		MimeMessageHelper msgHelper = new MimeMessageHelper(mimeMsg, true);
		
		msgHelper.setTo("bhagavanbejjipurapu@gmail.com");
		msgHelper.setSubject("Take a look at the image");
		msgHelper.setText("<h3>Here the attachment sended through springboot</h3>", true);
		
		msgHelper.addAttachment("image.jpg", new ClassPathResource("image.jpg"));
		javaMailSender.send(mimeMsg);
	}
	
	private void sendEmail() {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo("bhagavanbejjipurapu@gmail.com");
		msg.setSubject("Email set through spring boot");
		msg.setText("Hello\n\nThis is the testing mail form spring boot");
		
		javaMailSender.send(msg);
	}
}
