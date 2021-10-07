/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author erksm
 */

public class MailControl {
    
    
    public MailControl(){
        
    }
    public void sendEmail() throws AddressException, MessagingException{
        Properties properties=new Properties(); 
        Session session=Session.getInstance(properties,null);  
        MimeMessage message=new MimeMessage(session);
        
        message.setFrom(new InternetAddress("sonoojaiswal@sssit.org"));  
        message.addRecipient(Message.RecipientType.TO, new InternetAddress("sonoojaiswal@javatpoint.com"));  
        message.setHeader("Hi", "everyone");  
        message.setText("Hi, This mail is to inform you...");  
    }
    
    public void otros(){

   }  
    
}
