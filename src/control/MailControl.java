/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import javax.mail.Session;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import modelo.Sismo;

/**
 *
 * @author ytces
 */
public class MailControl {
    
    public MailControl(){
        
    }
    /**
     * se encarga de enviar el correo electronico sobre un sismo al asociado interesado
     * @param sismo el sismo al que se le va a notificar al asociado
     * @param nombre el nombre del asociado
     * @param destinatario el correo del asociado
     */
    public void sendEmail(Sismo sismo, String nombre, String destinatario ){
        System.out.println("Preparing ");
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");        
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");        
        String email = "martinezbonillaferks@gmail.com";
        String password = "pdcfpnbtsacqbezu";

        
        Session sesion  = Session.getDefaultInstance(properties, new Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication (email, password);
            }
        });
        Message mail = prepareMessage(sesion, email, destinatario, sismo, nombre);
        try{
            Transport.send(mail);
        }catch(MessagingException ex){
            Logger.getLogger(email);
        } 
        
    }
    /**
     * construye el mensaje que estará escrito en el correo electronico que se le enviara al asociado
     * @param session la sesion del correo
     * @param email el correo electronico
     * @param recepient el recipiente del mensaje preparado
     * @param sismo el sismo al que se le va a notificar al asociado
     * @param nombre el nombre del asociado
     * @return retorna el mensaje del correo preparado
     */
    private static Message prepareMessage(Session session, String email, String recepient, Sismo sismo, String nombre){
        try{
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email));  
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Alertar de nuevo Sismo");
            message.setText("Estimado "+ nombre+ " reciba un cordial saludo de parte de FérksEnterprise, se le informa que se ha registrado un nuevo sismo\n "
                    + "FAVOR ESTAR ATENTO A LAS PRECAUCIONES \n"
                    + "SISMO\n"                    
                    +"Provincia: "+ Utilities.convertirProvinciaToString(sismo.getProvincia())+" \n"
                    + "Descripción: "+ sismo.getLocalizacion()+"\n"
                    + "Magnitud de: "+Utilities.magnitudToString(sismo.getMagnitud()));
            return message;
        }catch(AddressException e){
            Logger.getLogger(email);
        }catch(MessagingException ex){
            Logger.getLogger(email);
        } 
        return null;
    }

}
