package com.pucpr.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Date;
import java.util.List;
import java.util.Properties;

@Configuration
public class MailSender {

    private String email_username = "clinilog.pucpr@hotmail.com";
    private String email_password = "pucpr@123";

    public void sendMail(String titulo, String mensagem, List<String> destinatarios) throws MessagingException {
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.office365.com");
        prop.put("mail.smtp.port", "587");
        // prop.put("mail.smtp.ssl.trust", "smtp.office365.com");

        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email_username, email_password);
            }
        });
        Message message = new MimeMessage(session);

        message.setFrom(new InternetAddress(email_username));

        // mail recipient address
        for(String destinatario: destinatarios) {
            InternetAddress addrTo = new InternetAddress( destinatario );
            message.addRecipient(Message.RecipientType.TO, addrTo);
        }

        message.setSubject(titulo);

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(mensagem, "text/html; charset=utf-8");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);

        message.setContent(multipart);

        Transport.send(message);

    }

}
