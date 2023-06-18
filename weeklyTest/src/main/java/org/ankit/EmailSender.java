package org.ankit;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import static org.ankit.ApiTest.mess;


public class EmailSender {
    static void sendMail( ) {

        // SMTP server information
        String host = "smtp.gmail.com";
        int port = 465;
        final String  username = "anktikumar55@gmail.com";
        final String  password = "mhcvoeghdpcwftrc";

        // Sender and recipient email address
        String from = "anktikumar55@gmail.com";
        String to = "ankitjadaun37@gmail.com";

        // Email subject and content
        String subject = "<----Getting Object--->";
        String content = mess;

        // Set properties and authentication
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");

        Authenticator auth = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        };

        // Create a session with the SMTP server
        Session session = Session.getInstance(props, auth);

        try {
            // Create an email message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setText(content);

            // Send the email
            Transport.send(message);

            System.out.println("Email sent successfully.");
        } catch (MessagingException e) {
            System.err.println("Error sending email: " + e.getMessage());
        }
    }
}

