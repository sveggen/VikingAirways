package model;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * This class is a Superclass, which can be inherited.
 * The class makes it possible to send an email to an recipient.
 *
 * @author Markus Sveggen
 * @version 23.11.2019
 */

public class Email {

    /**
     *
     * @param recipient     The addressee's email address.
     * @param subject       The subject of the email.
     * @param content       The content of the email.
     */
        public void sendEmail(String recipient, String subject, String content) {

            //Email addresses
            String to = recipient;
            String from = "vikingairways@gmail.com";

            //Credentials
            String username = from;
            String password = "nerdherd99";

            Properties prop = new Properties();
            prop.put("mail.smtp.host", "smtp.gmail.com");
            prop.put("mail.smtp.port", "465");
            prop.put("mail.smtp.auth", "true");
            prop.put("mail.smtp.socketFactory.port", "465");
            prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");

            Session session = Session.getInstance(prop,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(username, password); }
                    });
            try {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(from));
                message.setRecipients(
                        Message.RecipientType.TO,
                        InternetAddress.parse(to));
                message.setSubject(subject);
                message.setContent(content, "text/html");
                Transport.send(message);
/**
                Multipart multipart = new MimeMultipart();
                MimeBodyPart messageBodyPart = new MimeBodyPart();
                messageBodyPart.setText(content, "utf-8", "html");
                multipart.addBodyPart(messageBodyPart);


                //attachment
                MimeBodyPart attachmentBodyPart = new MimeBodyPart();
                attachmentBodyPart.attachFile(new File("/"), "application/pdf", null);
                multipart.addBodyPart(attachmentBodyPart);
                message.setContent(multipart);
                Transport.send(message);
 **/
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
}