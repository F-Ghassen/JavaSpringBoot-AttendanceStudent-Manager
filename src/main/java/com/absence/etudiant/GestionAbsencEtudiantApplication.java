package com.absence.etudiant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.sun.xml.fastinfoset.sax.Properties;

@SpringBootApplication
public class GestionAbsencEtudiantApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionAbsencEtudiantApplication.class, args);
	}
//	
//	@Bean
//	public JavaMailSender getJavaMailSender() {
//	    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//	    mailSender.setHost("smtp.gmail.com");
//	    mailSender.setPort(587);
//	     
//	    mailSender.setUsername("nasrih133@gmail.com");
//	    mailSender.setPassword();
//	     
//	    java.util.Properties props = mailSender.getJavaMailProperties();
//	    props.put("mail.transport.protocol", "smtp");
//	    props.put("mail.smtp.auth", "true");
//	    props.put("mail.smtp.starttls.enable", "true");
//	    props.put("mail.debug", "true");
//	     
//	    return mailSender;
//	}
	
	public String Index() {
		return "Index.html";
	}

}
