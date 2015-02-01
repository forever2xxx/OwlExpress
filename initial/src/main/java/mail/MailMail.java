package mail;
 
import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailParseException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
 
public class MailMail
{
	private JavaMailSender mailSender;
	private SimpleMailMessage simpleMailMessage;
	// TODO: user a template?
	
	public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage) {
		this.simpleMailMessage = simpleMailMessage;
	}
 
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
 
	public void sendMail(String from, String to, String subject, String msg) {
 
//		SimpleMailMessage message = new SimpleMailMessage();
		MimeMessage message = mailSender.createMimeMessage();
		try{
			MimeMessageHelper helper = new MimeMessageHelper(message, true);

//			helper.setFrom(simpleMailMessage.getFrom());
//			helper.setTo(simpleMailMessage.getTo());
//			helper.setSubject(simpleMailMessage.getSubject());
//			helper.setText(String.format(
//					simpleMailMessage.getText(), to, msg));
			
			helper.setFrom(from);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(msg);

			ClassLoader classLoader = getClass().getClassLoader();
			File file_read = new File(classLoader.getResource("sample_att.txt").getFile());
			FileSystemResource file_resource = new FileSystemResource(file_read);
			helper.addAttachment(file_read.getName(), file_resource);

		}catch (MessagingException e) {
			throw new MailParseException(e);
		}
		mailSender.send(message);
		     
//		message.setFrom(from);
//		message.setTo(to);
//		message.setSubject(subject);
//		message.setText(msg);
//		mailSender.send(message);	
	}
}