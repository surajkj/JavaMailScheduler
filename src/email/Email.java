/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package email;


import java.util.Date;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
/**
 *
 * @author Shrikant Katakdhond
 */
public class Email {

    /**
     * @param args the command line arguments
     */
   private static String USER_NAME = "ShrikantKatakdhond@ltfs.com";  // GMail user name (just the part before "@gmail.com")
//   private static String USER_NAME = "LNTFINSVCS\\VEN00253";
private static String PASSWORD = "password"; // GMail password

private static String RECIPIENT = "Surajkanojiya@ltfs.com";

//public static void main(String[] args) {
//    String from = USER_NAME;
//    String pass = PASSWORD;
//    String[] to = { RECIPIENT }; // list of recipient email addresses
//    String subject = "Java send mail example";
//    String body = "hi ....,!";
//
//    sendFromGMail(from, pass, to, subject, body);
//}

public static void sendFromGMail(String from, String pass, String[] to, String subject, String body) {
    Properties props = System.getProperties();
  String host = "POLTFMSEXJMBX01.LNTFINSVCS.COM";

    props.put("mail.smtp.starttls.enable", "true");

    props.put("mail.smtp.ssl.trust", host);
//    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.user", "VEN00253");
    props.put("mail.smtp.password", pass);
    props.put("mail.smtp.port", "25");
    props.put("mail.smtp.auth", "true");


    Session session = Session.getDefaultInstance(props);
    MimeMessage message = new MimeMessage(session);

    try {


        message.setFrom(new InternetAddress(from));
        InternetAddress[] toAddress = new InternetAddress[to.length];

        // To get the array of addresses
        for( int i = 0; i < to.length; i++ ) {
            toAddress[i] = new InternetAddress(to[i]);
        }

        for( int i = 0; i < toAddress.length; i++) {
            message.addRecipient(Message.RecipientType.TO, toAddress[i]);
        }
//-------------------------------
        BodyPart messageBodyPart = new MimeBodyPart();

         // Now set the actual message
         messageBodyPart.setText("Dear Datta,\n kute gela\n"
                 + "aksjbkas"
                 + "alscnbla");

         // Create a multipar message
         Multipart multipart = new MimeMultipart();

         // Set text message part
         multipart.addBodyPart(messageBodyPart);

         // Part two is attachment
         messageBodyPart = new MimeBodyPart();
         String filename = "D:\\subquery1.pdf";
         DataSource source = new FileDataSource(filename);
         messageBodyPart.setDataHandler(new DataHandler(source));
         messageBodyPart.setFileName(filename);
         multipart.addBodyPart(messageBodyPart);

         // Send the complete message parts
         message.setContent(multipart);
         
//------------------


        message.setSubject(subject);
//        message.setText(body);
//        message.setContent(mp);


        Transport transport = session.getTransport("smtp");


//        transport.connect(host, from, pass);
        transport.connect(host, "VEN00253", pass);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();

    }
    catch (AddressException ae) {
        ae.printStackTrace();
    }
    catch (MessagingException me) {
        me.printStackTrace();
    }
   }  
    }
    
