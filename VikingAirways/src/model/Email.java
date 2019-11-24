package model;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * This class is a Superclass, which can be inherited.
 * The class makes it possible to send an email to a recipient.
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

            //Email addresses (recipient and sender).
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

            //Creates a new session and passes the email and password for authentication.
            Session session = Session.getInstance(prop,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(username, password); }
                    });
            try {
                //Creates new message object
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(from));
                message.setRecipients( //Sets the recipient.
                        Message.RecipientType.TO,
                        InternetAddress.parse(to));
                message.setSubject(subject); //Pass the subject to the message-object.
                message.setContent(content, "text/html"); //Pass the content to the message-object..
                Transport.send(message); //Sends the message (Email).

            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
}