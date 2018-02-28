package com.worldapp.qa;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


public class EmailUtil {

    private static final String emailAddressTo = "";
    private static final String emailAddressFrom = "";

    public static void sendEmailToInfoSec(){
        Properties properties = new Properties();
        properties.put("mail.smtp.starttls.enable", "faslse");
        properties.put("mail.smtp.auth", "false");
        properties.put("mail.smtp.host", "localhost");
        properties.put("mail.smtp.port", "8080");
        Session session = Session.getDefaultInstance(properties);

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(emailAddressFrom));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailAddressTo));
            message.setSubject("Application checked");
            message.setText("This is a test");
            Transport.send(message);
        } catch (MessagingException e){
            e.printStackTrace();
        }

    }

}
