package classes;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.sql.DataSource;

public class Email {

    private static String arrivalAirport;
 
        public static void main(String[] args){
            Email email = new Email();
            String bookingNumber = "skj";
            String departureAirport = "sk";
            String firstName = "sak";
            email.sendEmail("m.sveggen@gmail.com", "Subject of email", "Hi, " + firstName + ". <br><br>" +
                    "Your bookingnumber is " + bookingNumber + ", for your flight from " + departureAirport +
                    " to " + arrivalAirport + "." + "<br>" +
                    "You can change the details of your flight" +
                    "<a href='http://localhost:8080/VikingAirways/BoardingCard>here</a>. <br><br>" +
                    "Have a nice flight! <br>" +
                    "<b>Viking Airways</b> <br>" +
                    "NO-4635 Kristiansand, Norway <br>" +
                    "Tel. +47 38 04 55 38 <br>"
);
        }

        public void sendEmail(String recipient, String subject, String content) {

            //Sender's email ID
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
                            return new PasswordAuthentication(username, password);
                        }
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