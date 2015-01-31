package mail;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = 
             new ClassPathXmlApplicationContext("Spring-Mail.xml");
 
    	MailMail mm = (MailMail) context.getBean("mailMail");
        mm.sendMail("riceowlexpress@gmail.com",
        			"mt17@rice.edu",
        			"Testing123", 
        			"Testing only\n\nHello Spring Email Sender");
 
    }
}