package com.dev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
@Service
public class emailservice {
	@Autowired
	private JavaMailSender mailsender;
	public String sendEmail(String toEmail,int otp)
	{
		SimpleMailMessage msg=new SimpleMailMessage();
		msg.setFrom("yashjain200502@gmail.com");
		msg.setTo(toEmail);
		msg.setText("Hello the OTP is : "+otp +" \n Thank you");
		msg.setSubject("OTP verification");
		mailsender.send(msg);
        return "mail sent successsfully";
	}

}
