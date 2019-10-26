package classes;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {

        public void sendEmail(String recipient, String subject, String content) {

            //Email addresses
            String to = recipient;
            String from = "vikingairways@gmail.com";

            //Credentials
            String username = "vikingairways@gmail.com";
            String password = "nerdherd2019";

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

                System.out.println("Email was successfully sent");

            } catch (MessagingException e) {
                e.printStackTrace();
                System.out.println("Email was not sent.");
            }
        }
}