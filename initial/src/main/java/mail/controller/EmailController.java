package mail.controller;

import mail.MailMail;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
	
	private String subject = "Testing123_You Have Got a Package!";
	private String content = "Dear Student,\nYou have a package. Please come and get it.";
	
	@RequestMapping("/sendmail")
	public void sendEmail(@RequestParam(value="email") String email_address) { 
		//TODO We do not allow empty email value right? How to enforce this?
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("Spring-Mail.xml");

		MailMail mm = (MailMail) context.getBean("mailMail");
		mm.sendMail("riceowlexpress@gmail.com",
					email_address,
					subject, 
					content);

    }
}
